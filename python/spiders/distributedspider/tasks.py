#encoding:utf-8
import requests
from bs4 import BeautifulSoup
from workers import app

@app.task
def crawl():
    print('正在抓取链接{}'.format(url))
    resp_text = requests.get(url).text
    soup = BeautifulSoup(resp_text, 'html.parser',from_encoding='utf-8')
    return soup.find('h1').text #.decode('unicode_escape')

