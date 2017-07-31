# -*- coding:utf-8 -*-
'''
Created on 2017年7月3日

@author: liuguoping
'''
def is_element_exist(driver, element_path, locator_way = 'id'):
    if locator_way == 'id':
        try:
            driver.find_element_by_id(element_path)
            return True
        except Exception:
            return False
            
    elif locator_way == 'class_name':
        try:
            driver.find_element_by_class_name()
            return True
        except Exception:
            return False
            