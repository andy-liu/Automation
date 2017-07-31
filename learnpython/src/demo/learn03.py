# -*- coding:utf-8 -*-
'''
Created on 2017年7月13日

@author: liuguoping
'''
import re
import os
import random
import string

# my_list = [1,2,3,4,5,6,7,8,9,10]
# print(my_list[-1:-5:-2])
# print('hello')


# test_html = ''' <a href = "www.baidu.com">test</a>
# '''
#
# test = re.search('<a href = (.*?)>', test_html, re.S).group(1)
# print(test)

# urls = re.findall('<a href = (.*?)>', test_html, re.S)
# for url in urls:
#     print(url)

# test_str = '123aaa456789abcd'
# print(re.search('([0-9]*)([a-d]*)', test_str).group(1))

my_tuple = (1, 'hello')
# print(test_tuple)
# print(*test_tuple)


# def test_tuple(*tuple):
#     print(*tuple)
# 
# test_tuple(*my_tuple)
# a=0
# b=1
# for i in range(5):
#     try:
#         print('begin')
#         b/a
#     except Exception:
#         continue
#     print('hello')

cur_dir = 'D:\spider_result'
# folder_name = 'image' + str(random.randint(1000, 9999))
folder_name = 'image' + '_'+ ''.join(random.sample(string.ascii_letters + string.digits, 8))
print(os.path.join(cur_dir, folder_name))
# salt = ''.join(random.sample(string.ascii_letters + string.digits, 8))

# if os.path.isdir(cur_dir):
#     os.mkdir(os.path.join(cur_dir, folder_name))


    


