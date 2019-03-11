# coding=utf-8
from flask import Flask
from werkzeug.contrib.profiler import ProfilerMiddleware

app = Flask(__name__)
#可以很方便地使用ProfilerMiddleware添加性能分析。请求页面的时候，就可以获得分析的结果
app.wsgi_app = ProfilerMiddleware(app.wsgi_app)


@app.route('/')
def hello():
    return 'Hello'


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=9000)
