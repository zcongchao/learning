# coding=utf-8
import os

from flask import Flask
from werkzeug.wsgi import SharedDataMiddleware

app = Flask(__name__)
app.wsgi_app = SharedDataMiddleware(app.wsgi_app, {
    '/static/': os.path.join(os.path.dirname(__file__), 'static')
})


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9000)

"""
假设程序所在目录的static子目录下有一个叫作main的文件．可以使用http://localhost:9000 /static/main.js访问
"""
