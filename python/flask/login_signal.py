# coding=utf-8
from flask import Flask, request, redirect, url_for
import flask_login
from flask_sqlalchemy import SQLAlchemy


app = Flask(__name__)
app.secret_key = 'super secret string'
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:6964433@localhost:3306/test'

db = SQLAlchemy(app)

login_manager = flask_login.LoginManager()
login_manager.init_app(app)


password = '123456'


class User(flask_login.UserMixin, db.Model):
    __tablename__ = 'login_users'
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(128), nullable=False)
    login_count = db.Column(db.Integer, default=0)
    last_login_ip = db.Column(db.String(128), default='unknown')


db.create_all()

#添加user_logged in 信号后， 一登录就会触发user_logged_in信号， 增加登录次数， 并添加 最近登录IP
@flask_login.user_logged_in.connect_via(app)
def _track_logins(sender, user, **extra):
    user.login_count += 1
    user.last_login_ip = request.remote_addr
    db.session.add(user)
    db.session.commit()

#使HJ user_loader装饰器的回调函数非常重要， 它将决定user对象是杏在登录状态
@login_manager.user_loader
def user_loader(id):
    user = User.query.filter_by(id=id).first()
    return user


@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'GET':
        return '''
<form action='login' method='POST'>
    <input type='text' name='name' id='name' placeholder='name'></input>
    <input type='password' name='pw' id='pw' placeholder='password'></input>
    <input type='submit' name='submit'></input>
</form>
               '''

    name = request.form.get('name')
    if request.form.get('pw') == password:
        user = User.query.filter_by(name=name).first()
        if not user:
            user = User(name=name)
            db.session.add(user)
            db.session.commit()
        flask_login.login_user(user)
        return redirect(url_for('protected'))

    return 'Bad login'


@app.route('/protected')
@flask_login.login_required
def protected():
    user = flask_login.current_user
    return 'Logged in as: {}| Login_count: {}|IP: {}'.format(
        user.name, user.login_count, user.last_login_ip)


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9000, debug=True)

"""
•	is_authenticated： 是否被验证。
•	is active：是否被激活。
•	is anonymous：是再是匿名用户。
•	get_id（）：获得用户的时， 转换为Unicode类型。
"""
