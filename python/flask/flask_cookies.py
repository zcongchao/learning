#encoding:utf-8

from flask import Flask, make_response, request
app = Flask(__name__)

@app.route("/")
def set_cookie():
    resp = make_response("set cookie ok")
    resp.set_cookie("zou","python")
    resp.set_cookie("zou2","python2",max_age=3600)
    resp.headers["set-cookie"] = "wancheng3=python3; Expires=Mon, 27-Nov-2017 07:57:17 GMT; Max-Age=3600; Path=/"
    return resp

@app.route("/get_cookie")
def get_cookie():
    cookie = request.cookies.get("zou")
    return "cookie wancheng2=%s" %cookie

if __name__ == "__main__":
    app.run(debug=True)