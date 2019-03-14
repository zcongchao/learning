#encoding:utf-8

from celery import Celery

"""
做Celery实例的初始化工作，include是在初始化celery app的时候需要引入的内容，主要就是注册为网络调用的函数所在的文件
"""

app = Celery('crawl_task', include=['tasks'], broker='amqp://zoucongchao:6964433zou@localhost/myvhost', backend='redis://127.0.0.1:6379/3')

app.conf.update(
    CELERY_TIMEZONE='Asia/Shanghai',
    CELERY_ENABLE_UTC=True,
    CELERY_ACCEPT_CONTENT=['json'],
    CELERY_TASK_SERIALIZER='json',
    CELERY_RESULT_SERIALIZER='json',
)
