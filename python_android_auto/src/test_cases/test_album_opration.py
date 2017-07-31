# -*- coding:utf-8 -*-
'''
Created on 2017年7月5日

@author: liuguoping
'''

import unittest
import random
from appium.webdriver.common.touch_action import TouchAction
from appium import webdriver


class TestAlbumOption(unittest.TestCase):
    def setUp(self):
        desired_capabilities = {}
        desired_capabilities['platformName'] = 'Android'
        desired_capabilities['deviceName'] = 'a26632af'
        desired_capabilities['platformVersion'] = '7.0'
        desired_capabilities['noReset'] = 'true'
        desired_capabilities['appPackage'] = 'com.zerozero.hover'
        desired_capabilities['appActivity'] = '.newui.splash.SplashActivity'
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', desired_capabilities)
        self.driver.implicitly_wait(5)
            
    def tearDown(self):
        self.driver.quit()
        
    def test_delete_image_album(self):
        print('testCase: Delete 2 images from album')
        self.driver.find_element_by_id('com.zerozero.hover:id/iv_album').click()
        image_list = self.driver.find_elements_by_id('com.zerozero.hover:id/iv_thumb')
        image_count_before = len(image_list)
        action = TouchAction(self.driver);
        action.long_press(image_list[0]).release().perform();
        image_list[random.randint(1, image_count_before)].click()
        
        self.driver.find_element_by_id('com.zerozero.hover:id/iv_activity_album2_delete').click()
        self.driver.find_element_by_id('com.zerozero.hover:id/hint_confirm').click()
        self.driver.press_keycode(4)#back
        self.driver.find_element_by_id('com.zerozero.hover:id/iv_album').click()
        image_list = self.driver.find_elements_by_id('com.zerozero.hover:id/iv_thumb')
        image_count_after = len(image_list)
        print (image_count_before-image_count_after)
        self.assertTrue((image_count_before - image_count_after) == 2, 'Fail to delete image')
        self.driver.find_element_by_id('com.zerozero.hover:id/iv_activity_album2_close').click()
        
    def test_delete_image_preview_album(self):
        print('testCase: Delete 1 image in preview page from album')
        self.driver.find_element_by_id('com.zerozero.hover:id/iv_album').click()
        image_list = self.driver.find_elements_by_id('com.zerozero.hover:id/iv_thumb')
        image_count_before = len(image_list)
        image_list[random.randint(1, image_count_before)].click()
        self.driver.find_element_by_id('com.zerozero.hover:id/iv_delete').click()
        self.driver.find_element_by_id('com.zerozero.hover:id/hint_confirm').click()
        self.driver.find_element_by_id('com.zerozero.hover:id/iv_back').click()
        image_list = self.driver.find_elements_by_id('com.zerozero.hover:id/iv_thumb')
        image_count_after = len(image_list)
        self.assertTrue((image_count_before-image_count_after) == 1, 'Fail to delete image')
        self.driver.find_element_by_id('com.zerozero.hover:id/iv_activity_album2_close').click()
        