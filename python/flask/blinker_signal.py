# coding=utf-8
from blinker import signal
"""
connect是订阅信号的方法。第二个参数是可选的 ， 用于确定信号的发送端 ..started.conn­ect(round_two, sender=2）” 表示值为2的时候才会接收
"""
started = signal('test-started')


def each(round):
    print 'Round {}!'.format(round)


def round_two(round):
    print 'Only {}'.format(round)


started.connect(each)
started.connect(round_two, sender=2)

for round in range(1, 4):
    started.send(round)
