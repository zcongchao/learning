from scrapy.crawler import CrawlerProcess
from scrapy.utils.project import get_project_settings

import sys

process = CrawlerProcess( get_project_settings())

name = ["cnblogs"]

process.crawl('cnblogs')

process.start()