# -*- coding: utf-8 -*-
"""
Created on Mon Nov 26 09:19:32 2018

@author: Administrator
"""

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

import xlrd
from datetime import date,datetime

import selenium.webdriver.support.ui as ui
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait


    
    
row = 2



def read_excel(row):

    wb = xlrd.open_workbook(filename=file)#打开文件
    
    
    #print(wb.sheet_names())#获取所有表格名字
    row = row
    sheet1 = wb.sheet_by_index(0)#通过索引获取表格
    #cols = sheet1.col_values(6)#获取列内容
    return sheet1.row(row)[5].value
    
def wait(con, term):
    
    while True:
        try:
            WebDriverWait(driver, 15).until(
                EC.presence_of_element_located( con , term)
            )
        except Exception,e:
            print e
            break


def change_value(ip, path, value):
    
    ip = ip
    name = driver.find_element_by_id('scp')
    name.send_keys(ip)
    wait(By.ID, 'ss')
    
    btc = driver.find_element_by_id('ss')
    btc.click()
    wait(By.XPATH, "//select[@name='sjys']")
    
    
    select = driver.find_element_by_xpath("//select[@name='sjys']")
    select.click()
    wait(By.XPATH, path)
    
     #"//option[@value='ZCE']", "//option[@value='SHFE']"
    option = driver.find_element_by_xpath(path)
    option.click()
    wait(By.XPATH, "//img[@src='img/icon_edit.png']")
    
    
    
    #if
    write = driver.find_element_by_xpath("//img[@src='img/icon_edit.png']")
    write.click()
    time.sleep(2)
    
    value = value
    arg = driver.find_element_by_id("oper_val1")
    arg.clear()
    time.sleep(2)
    
    arg.send_keys(value)
    time.sleep(2)
    
    sure = driver.find_element_by_id("btn1")
    sure.click()
    wait(By.XPATH, "//input[@class='seach-btn']")
    
    
    seach_btn = driver.find_element_by_xpath("//input[@class='seach-btn']")
    seach_btn.click()
    time.sleep(2)
    
    print ip + "is done!"    
    
    name = driver.find_element_by_id('scp')
    name.clear()
    time.sleep(2)



if __name__ == '__main__':
    
    driver = webdriver.Firefox(executable_path='D:\Anaconda2\Scripts\geckodriver.exe')
    driver.get("http://qxjr.xpgsoft.com/28/login.aspx")
    username = driver.find_element_by_name("username")
    password = driver.find_element_by_name("password")
    login_button = driver.find_element_by_name("btn")
    
    username.send_keys("js")
    password.send_keys("js2018")
    login_button.click()
    time.sleep(3)
    
    curr= driver.find_element_by_xpath("//li[@data-id='3']")
    curr.click()
    time.sleep(2)


    current = driver.find_element_by_xpath("//a[@href='xtsz_cp_cs_2v.aspx']")
    current.click()
    time.sleep(2)
    #跳转新页面
    driver.switch_to.frame("main-iframe")
    time.sleep(2)
    
    file = 'D:/kuapingzhongcanshu.xlsx'
    pag = [(u'豆二', 2, "//option[@value='DCE']"),(u'豆油', 3, "//option[@value='DCE']")]
    for page in pag:
        ip, row, path = page
        
        value = str(read_excel(row))
        
        #print type(value)
        
        change_value(ip, path, value)
    
    
    
    
    
    
    
    
    










"""

#获取当前页句柄
print num
print num[0]
num = driver.window_handles
#获取当前页句柄
print num
print num[0]

current = driver.find_element_by_class_name("current")
#current = driver.find_element_by_xpath("//li[@data-id="3"]")
cur.click()
"""