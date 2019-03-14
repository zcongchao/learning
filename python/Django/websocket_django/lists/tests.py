from django.urls import resolve
from django.test import TestCase
from django.http import HttpRequest

from lists.views import home_page


class HomePageTest(TestCase):
    
    #测试函数
    def test_home_page_returns_correct_html(self):
        
        request = HttpRequest()
        response = home_page(request)
        
        #获取响应内容
        html = response.content.decode('utf8')
        
        #判断内容是否以<html>开头
        self.assertTrue(html.startswith('<html>'))
        
        #判断<title>To-Do lists</title>是否在内容里
        self.assertIn('<title>To-Do lists</title>', html)
        
        #判断内容是否以<html>结尾
        self.assertTrue(html.endswith('</html>'))
