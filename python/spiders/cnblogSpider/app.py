#!/usr/bin/env python3
# encoding: utf-8

from flask import Flask
import os

app=Flask(__name__) #创建1个Flask实例

#路由系统生成 视图对应url,1. decorator=app.route() 2. decorator(first_flask)
@app.route('/') 
def index(): 
    #response  
    return 'Hello World'  

@app.route('/runspider')
def runspider():
    #必须切换目录，不然爬虫跑不起来
    os.chdir('/home/zou/cnblogSpider')
    #执行命令，让爬虫启动
    os.system('python scripts.py')

    return "runspider done!"


if __name__ == '__main__':
    app.run(debug=True) #,host="0.0.0.0", port=8082             #启动socket
