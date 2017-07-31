# -*- coding:utf-8 -*-
'''
Created on 2017年5月25日

@author: liuguoping
'''
if __name__ == '__main__':
    print('myself')
else:
    print('others')
    
def my_function(my_str):
    print(my_str)
    
# my_str = input()
# print(my_str)
f = open('D:\data_test\python.txt', 'w')
f.write("abcdefhijklmnopqrs")
f.close()

with open('D:\data_test\python.txt', 'rb') as f:
#     print(f.tell())
#     print(f.readline(), end = '')
#     print(f.read(1))
#     print(f.read(2))
#     f.seek(2, 0)
    f.seek(-2,2)
    print(f.read(2))
#     for line in f:
#         print(line, end = '')
#     print(f.tell())
# my_str = f.read()
# print(my_str)
# my_str = f.readlines()
# print(my_str)
# f.close()