# coding=utf-8
from collections import OrderedDict

from flask import Flask, jsonify
from werkzeug.wrappers import Response
from werkzeug.wsgi import DispatcherMiddleware

app = Flask(__name__)
json_page = Flask(__name__)


class JSONResponse(Response):
    @classmethod
    def force_type(cls, rv, environ=None):
        if isinstance(rv, dict):
            rv = jsonify(rv)
        return super(JSONResponse, cls).force_type(rv, environ)
#访问以／json开头的地址时都默认自动用jsonify格式化,http://0.0.0.0:9000/json/hello/
json_page.response_class = JSONResponse


@json_page.route('/hello/')
def hello():
    return {'message': 'Hello World!'}

#访问其他地址不受影响
@app.route('/')
def index():
    return 'The index page'

#DispatcherMiddleware是可以调度多个应用的中间件
app.wsgi_app = DispatcherMiddleware(app.wsgi_app, OrderedDict((
    ('/json', json_page),
)))

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9000)
