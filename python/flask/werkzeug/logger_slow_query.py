# coding=utf-8
import logging
from logging.handlers import RotatingFileHandler

from flask import Flask, request, jsonify
from flask_sqlalchemy import get_debug_queries

from ext import db
from users import User

app = Flask(__name__)
app.config.from_object('config')
app.config['DATABASE_QUERY_TIMEOUT'] = 0.0001
app.config['SQLALCHEMY_RECORD_QUERIES'] = True
db.init_app(app)

formatter = logging.Formatter(
    "[%(asctime)s] {%(pathname)s:%(lineno)d} %(levelname)s - %(message)s")
handler = RotatingFileHandler('slow_query.log', maxBytes=10000, backupCount=10)
handler.setLevel(logging.WARN)
handler.setFormatter(formatter)
app.logger.addHandler(handler)

with app.app_context():
    db.drop_all()
    db.create_all()


@app.route('/users', methods=['POST'])
def users():
    username = request.form.get('name')

    user = User(username)
    print 'User ID: {}'.format(user.id)
    db.session.add(user)
    db.session.commit()

    return jsonify({'id': user.id})


@app.after_request
def after_request(response):
    for query in get_debug_queries():
        if query.duration >= app.config['DATABASE_QUERY_TIMEOUT']:
            app.logger.warn(
                ('\nContext:{}\nSLOW QUERY: {}\nParameters: {}\n'
                 'Duration: {}\n').format(query.context, query.statement,
                                          query.parameters, query.duration))
    return response


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9000)
"""
http -f post http://0.0.0.0:9000/users name=xiaoming
slow_query.log看到
[2019-03-11 15:38:00,074] WARNING in logger_slow_query: 
Context:logger_slow_query.py:36 (users)
SLOW QUERY: INSERT INTO users2 (name) VALUES (%s)
Parameters: ('xiaoming',)
Duration: 0.0116319656372

[2019-03-11 15:38:00,075] WARNING in logger_slow_query: 
Context:logger_slow_query.py:38 (users)
SLOW QUERY: SELECT users2.id AS users2_id, users2.name AS users2_name 
FROM users2 
WHERE users2.id = %s
Parameters: (1L,)
Duration: 0.000463962554932
"""
