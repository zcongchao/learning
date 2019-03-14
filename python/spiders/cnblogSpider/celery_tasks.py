from celery import Celery

#broker:任务队列的中间人，使用rabbitmq做任务队列
#backend:任务执行结果的存储；使用redis做结果存储
app = Celery('tasks', broker='amqp://username:passwd@ip:port/varhost',backend='redis://username:passwd@ip:6390/db')

@app.task
def add(x, y):
    return x + y

if __name__ == '__main__':
    result = add.delay(30, 42)