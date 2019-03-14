#encoding:utf-8
from celery import Celery

#broker:任务队列的中间人，使用rabbitmq做任务队列
#backend:任务执行结果的存储；使用redis做结果存储
app = Celery('tasks', broker='amqp://zoucongchao:6964433zou@localhost/myvhost', backend='amqp')#username:passwd@ ,backend='redis://127.0.0.1:6379/0'  127.0.0.1:15672/

@app.task
def add(x, y):
    return x + y


