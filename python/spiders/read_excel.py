# -*- coding: utf-8 -*-

import xlrd
from datetime import date,datetime

file = 'D:/kuapingzhongcanshu.xlsx'

pag = [(u'豆二', 2, "//option[@value='DCE']"),(u'豆油', 3, "//option[@value='DCE']")]

for page in pag:
    ip, row, path = page
    print ip
    
    
row = 2



def read_excel(row):

    wb = xlrd.open_workbook(filename=file)#打开文件
    
    
    #print(wb.sheet_names())#获取所有表格名字
    row = row
    sheet1 = wb.sheet_by_index(0)#通过索引获取表格
    cols = sheet1.col_values(6)#获取列内容
    print(sheet1.row(row)[5].value)
    
    
    """
    sheet2 = wb.sheet_by_name('Sheet1')#通过名字获取表格
    print(sheet1,sheet2)
    print(sheet1.name,sheet1.nrows,sheet1.ncols)

    rows = sheet1.row_values(2)#获取行内容
    cols = sheet1.col_values(3)#获取列内容
    print(rows)
    print(cols)

    print(sheet1.cell(1,0).value)#获取表格里的内容，三种方式
    print(sheet1.cell_value(1,0))
    print(sheet1.row(1)[0].value)
    """
    
if __name__ == "__main__":
    read_excel(row)


