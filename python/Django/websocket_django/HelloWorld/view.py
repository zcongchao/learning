# -*- coding: utf-8 -*-
"""
Created on Sat Dec 29 19:34:01 2018

@author: Administrator
"""

from django.http import HttpResponse
from django.shortcuts import render
def hello(request):
    context={}

    context['tang']='tangyuanyuan!'
    context['zou']="zoucongchao!"

    return render(request,'hello.html',context)