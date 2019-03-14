#encoding:utf-8

from celery import Celery

backend = 'redis://127.0.0.1:6379/6'
broker= "amqp://zoucongchao:6964433zou@localhost/myvhost"

app = Celery('tasks', broker=broker, backend=backend)

@app.task
def add(x, y):
    return x + y
