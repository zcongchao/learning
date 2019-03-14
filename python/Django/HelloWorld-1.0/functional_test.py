# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import unittest

class NewVisitorTest(unittest.TestCase):
    def setUp(self):
        self.browser=webdriver.Firefox()
        self.browser.implicitly_wait(3)
    def tearDown(self):
        self.browser.quit()

    def test_post_and_retrieve(self):
        self.browser.get('http://127.0.0.1:8000/')
        inputbox=self.browser.find_element_by_id("id_new_item")
        
        inputbox.send_keys('邹聪超')
        time.sleep(3)
        inputbox.send_keys(Keys.ENTER)
        time.sleep(3)
         
        table=self.browser.find_element_by_id("id_list_table")
        rows=table.find_elements_by_tag_name('tr')
        
        #self.assertIn('邹聪超是傻子，只知道吃饭睡觉',[row.text for row in rows])
        self.assertIn('邹聪超是傻子，只知道吃饭睡觉',[row.text for row in rows])
        
if __name__=='__main__':
    unittest.main(warnings='ignore')