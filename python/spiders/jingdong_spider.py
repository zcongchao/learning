# -*- coding: utf-8 -*-

# import datetime
# import datetime
import codecs
import datetime
from bs4 import BeautifulSoup

from selenium import webdriver
import selenium.webdriver.support.ui as ui
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait
import time


class JdSpider(object):

    def get_goods(self,driver, goods):

        ele_toname = driver.find_element_by_id('key')
        
        ele_search = driver.find_element_by_class_name('button')
        
        
        
        ele_toname.clear()
        ele_toname.send_keys(goods)
        ele_toname.click()
        
        
        ele_search.click()
        page_num=0
        while True:
            try:
                WebDriverWait(driver, 10).until(
                    EC.title_contains(unicode(goods))
                )
            except Exception,e:
                print e
                break
            time.sleep(5)

            js = "window.scrollTo(0, document.body.scrollHeight);"
            driver.execute_script(js)
            time.sleep(5)

            htm_const = driver.page_source
            soup = BeautifulSoup(htm_const,'html.parser', from_encoding='utf-8')
            
            
            infos = soup.find_all(class_="gl-item")
            
            
            f = codecs.open(unicode(goods)+ u'.html', 'a', 'utf-8')
            for info in infos:
                f.write(str(page_num)+'--'*50)
                content = info.get_text().replace(" ","").replace("\t","").strip()
                for line in [ln for ln in content.splitlines() if ln.strip()]:
                    f.write(line)
                    f.write('\r\n')
            f.close()
            try:
                next_page = WebDriverWait(driver, 10).until(
                EC.visibility_of(driver.find_element_by_css_selector(".item.next"))
                )
                next_page.click()
                page_num+=1
                time.sleep(10)
            except Exception,e:
                print e
                break

    def crawl(self,root_url, goods):
         
         driver = webdriver.Firefox(executable_path='D:\Anaconda2\Scripts\geckodriver.exe')
         driver.set_page_load_timeout(50)
         driver.get(root_url)
         driver.maximize_window() # 将浏览器最大化显示
         driver.implicitly_wait(10) # 控制间隔时间，等待浏览器反映
         self.get_goods(driver,goods)


if __name__=='__main__':
    spider = JdSpider()
    spider.crawl('https://www.jd.com/',u"thinkpad")