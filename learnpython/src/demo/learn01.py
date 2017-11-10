# -*- coding:utf-8 -*-
'''
Created on 2017年4月22日

@author: liuguoping
'''
from _ctypes import sizeof
from builtins import sorted

life = "人生苦短，我用python！"
# print(life)
# print(life * 2)
# print(life+'test')
tuple01 = ('world', '!')
# tuple02 = ('hello', tuple01, mylist)
# print (tuple01)
# print (tuple02)

mylist = [1,2,3,4,'Apple','hello',5,6]
mylist02 = [mylist, 9]
mylist03 = [5, mylist, tuple01]
# print (mylist03)
# print (mylist03)
# print (mylist02)
# print (mylist02[0])
# mylist[4] = "ZeroZero"
# print (mylist)
# print (mylist[0]+mylist[-1])
# print (mylist[-4 : -1])

# mydict = dict([('name', 'andy'), ('age', 18)])
# dict02 = {}
# print (mydict)
# dict02['FirstName'] = 'Andy'
# dict02['LastName'] = 'Lau'
# print (dict02)

# for i in range(10):
#     print(i)
#     for j in range(10,15):
#         print(j)
# else:
#     print("************")
    
# list_int = [1,2,3,4,5,6,7,8,9,10]
# it_int = iter(list_int)
# print(len(list_int))
# 
# for i in it_int:
#     print(i, end=" ")

# def my_function(n):
#     a, b = 0, 1
#     for i in range(10):
#         yield a
#         a, b = b, a + b
# 
# f = my_function(10)
# for i in range(10):
#     print(next(f), end = " ")

# def myprint(list_int):
#     list_int[0] = 10
#     print(list_int[0])
# 
# list_int = [1,2,3,4]
# myprint(list_int)
# print(list_int[0])

# def myfunc(name, age='27'):
#     print('name: '+ name)
#     print('age: '+ age)
#     
# myfunc(age='30', name='Jay')
# 
# f = lambda a, b: a+b
# print(f(2,3))
my_list = [1,2,3,4,5,6,7,8,9,9,10]
# my_list.reverse()
# my_list.sort()
# my_list.extend(['hello', 'world'])
# my_list.append(11)
# my_list.insert(9, 'insert')
# my_list.remove('insert')
# print(my_list.pop(8))
# print(my_list.index(9))
# print(my_list)
# print(my_list.copy())

# for i in range(4):
#     print("**")
# my_dict = dict(name='Andy', age=18, country='China')
# my_dict['country'] = 'USA'
# for k, v in my_dict.items():
#     print(k, v)

my_list = [10, 9, 8, 7]
for i in sorted(my_list):
    print(i)
print(sorted(set(my_list)))

learn02.my_function('hello')




