# coding=utf-8

from flask import Flask
from flask_script import Manager
from flask_migrate import Migrate, MigrateCommand

from ext import db

app = Flask(__name__)
app.config.from_object('config')

db.init_app(app)

import users  # noqa
#添加数据库迁移支恃
migrate = Migrate(app, db)
manager = Manager(app)
manager.add_command('db', MigrateCommand)


if __name__ == '__main__':
    manager.run()
