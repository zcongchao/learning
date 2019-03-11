# coding=utf-8

from flask import Flask
from flask_debugtoolbar import DebugToolbarExtension

app = Flask(__name__)

app.debug = True

app.config['SECRET_KEY'] = 'a secret key'

toolbar = DebugToolbarExtension(app)


@app.route('/')
def hello():
    return '<body></body>'


if __name__ == '__main__':
    #debug要为True才可以看到调试边栏
    app.run(host='0.0.0.0', port=9000, debug=app.debug)
