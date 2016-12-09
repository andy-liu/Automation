# -*- coding:utf-8 -*-
'''
Created on 2016年10月27日

@author: liuguoping
'''
from selenium import webdriver
from time import sleep

print('hello world!')
driver = webdriver.Chrome()
driver.get('http://0s9fsl12p3.aws.test.gethover.com/')
driver.maximize_window()
sleep(2)
driver.quit()
