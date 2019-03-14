# -*- coding: utf-8 -*-

from requests import *




agent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0" 
header = { "HOST": "zhihu-web-analytics.zhihu.com", "Referer": "https://www.zhihu.com/", "User-Agent": agent, }

def get_xsrf():
    response = session().post("https://www.zhihu.com/signup?next=%2F", headers=header)
    return response.cookies['_xsrf']
    


if __name__ == "__main__":
    
    aa = get_xsrf()
    print(aa)
    
