#encoding:utf-8

import scrapy

class CnblogsSpider(scrapy.Spider):
    #爬虫的名称
    name = "cnblogs"
    #允许的域名
    allowed_domains = ['cnblogs.com']
    start_urls = [
        "http://www.cnblogs.com/qiyeboy/default.html?page=1"
    ]
    def parse(self, response):
        #里面实现网页的而解析

        # 首先抽取所有的文章
        papers = response.xpath(".//*[@class='day']")
        # 从每篇文章中抽取数据
        for paper in papers:
            #链接
            url = paper.xpath(".//*[@class='postTitle']/a/@href").extract()[0]
            #标题
            title = paper.xpath(".//*[@class='postTitle']/a/text()").extract()[0]
            #时间
            time = paper.xpath(".//*[@class='dayTitle']/a/text()").extract()[0]
            #内容
            content = paper.xpath(".//*[@class='postCon']/div/text()").extract()[0]
            
            print(title)
