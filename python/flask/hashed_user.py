# coding=utf-8
from flask import Flask
#Werkzeug中提供了密码加盐的哈希函数
from werkzeug.security import generate_password_hash, check_password_hash
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.ext.hybrid import hybrid_property

app = Flask(__name__)
app.config.from_object('config')

db = SQLAlchemy(app)


class User(db.Model):
    __tablename__ = 'hashed_users'
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(128), nullable=False)
    _password = db.Column(db.String(256), nullable=False)

    def __init__(self, name, password):
        self.name = name
        self.password = password
    #装饰器hybridproperty把password变成了一个混合属性，可以通过user.password属性来访问哈希的密码，
    #也会在给user.password赋值的时候触发password.setter
    @hybrid_property
    def password(self):
        return self._password

    @password.setter
    def _set_password(self, plaintext):
        self._password = generate_password_hash(plaintext)
    #使用check_password hash来验证
    def verify_password(self, password):
        return check_password_hash(self.password, password)

db.drop_all()
db.create_all()
