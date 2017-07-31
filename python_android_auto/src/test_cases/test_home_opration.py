# -*- coding:utf-8 -*-
'''
Created on 2017年7月3日

@author: liuguoping
'''
import traceback
import unittest
from time import sleep
from hover_pages.home_page import HomePage
from appium import webdriver
from appium.webdriver.connectiontype import ConnectionType


class TestHomeOption(unittest.TestCase):
    def setUp(self):
        desired_capabilities = {}
        desired_capabilities['platformName'] = 'Android'
        desired_capabilities['deviceName'] = 'TWGDU16513002448'
        desired_capabilities['platformVersion'] = '6.0'
        desired_capabilities['noReset'] = 'true'
        desired_capabilities['appPackage'] = 'com.zerozero.hover'
        desired_capabilities['appActivity'] = '.newui.splash.SplashActivity'
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', desired_capabilities)
        # self.driver.implicitly_wait(5)
    
    def tearDown(self):
        self.driver.quit()

    def test_navigate_from_home(self):
        home_page = HomePage(self.driver)
        home_page.nav_to_social()
        self.assertTrue(self.driver.current_activity == '.newui.socialhub.SocialHubActivity', 'Fail to nav to social hub')
        self.driver.press_keycode(4)

        home_page.nav_to_settings()
        self.assertTrue(self.driver.current_activity == '.SettingsBaseActivity', 'Fail to nav to settings')
        self.driver.press_keycode(4)

        home_page.nav_to_album()
        self.assertTrue(self.driver.current_activity == '.album2.Album2Activity', 'Fail to nav to Album')
        self.driver.press_keycode(4)

    def test_scene_unlock(self):
        home_page = HomePage(self.driver)
        if(home_page.is_scene_lock()):
            home_page.scene_unlock()
            self.assertFalse(home_page.is_scene_lock(), 'Failed to unlock')
        else:
            print('scene is unlocked now')