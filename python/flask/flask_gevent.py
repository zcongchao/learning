#encoding:utf-8

from flask import Flask, request, g
from gevent.pywsgi import WSGIServer
from gevent import monkey
import time
#猴子补丁
monkey.patch_all()

app = Flask(__name__)
app.config.update(DEBUG=True)

@app.route("/test/", methods=["GET"])
def test():
    return 'hello test'

@app.route('/asyn/', methods=['GET'])
def test_asyn_one():
    print("asyn has a request!")
    time.sleep(10)
    return 'hello asyn'

if __name__ == "__main__":

    http_server = WSGIServer(('', 5000), app)
    http_server.serve_forever()