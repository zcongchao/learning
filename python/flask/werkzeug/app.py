# coding=utf-8
import random

from flask import Flask, g, render_template
from ext import db
from users import User
app = Flask(__name__, template_folder='../../templates')
app.config.from_object('config')
db.init_app(app)


def get_current_user():
    users = User.query.all()
    return random.choice(users)

# 在第一次请求之前调用，可以在此方法内部做一些初始化操作
@app.before_first_request
def setup():
    db.drop_all()
    db.create_all()
    fake_users = [
        User('xiaoming', 'xiaoming@zou.com'),
        User('zou', 'zou@zou.com'),
        User('admin', 'admin@zou.com')
    ]
    db.session.add_all(fake_users)
    db.session.commit()

# 在每一次请求之前调用，这时候已经有请求了，可能在这个方法里面做请求的校验
# 如果请求的校验不成功，可以直接在此方法中进行响应，直接return之后那么就不会执行视图函数
@app.before_request
def before_request():
    g.user = get_current_user()

# 请每一次请求之后都会调用，会接受一个参数
@app.teardown_appcontext
def teardown(exc=None):
    if exc is None:
        db.session.commit()
    else:
        db.session.rollback()
    db.session.remove()
    g.user = None

#上下文处理的装饰器， 返回的字典中的键可以在上下文中使用。
@app.context_processor
def template_extras():
    return {'enumerate': enumerate, 'current_user': g.user}

#接收状态码， 可以向定义返回这种状态码的响应的处理方法
@app.errorhandler(404)
def page_not_found(error):
    return 'This page does not exist', 404

#在使用Jinja2模板的时候可以方便地注册过滤器,在模板中可以这样 使用 “ ｛{ user.name | capitalize } ｝”
@app.template_filter('capitalize')
def reverse_filter(s):
    return s.capitalize()


@app.route('/users')
def user_view():
    users = User.query.all()
    return render_template('chapter3/section4/user.html', users=users)


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9000)

"""
http -f get http://0.0.0.0:9000/users
HTTP/1.0 200 OK
Content-Length: 163
Content-Type: text/html; charset=utf-8
Date: Mon, 11 Mar 2019 08:41:52 GMT
Server: Werkzeug/0.14.1 Python/2.7.12

<h2>Current User: zou</h2>
<ul>
    
    <li>
        1 Xiaoming
    </li>
    
    <li>
        2 Zou
    </li>
    
    <li>
        3 Admin
    </li>
    
</ul>
"""
