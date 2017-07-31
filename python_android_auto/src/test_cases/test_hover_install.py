# -*- coding:utf-8 -*-
'''
Created on 2017年6月14日

@author: liuguoping
'''
import os
import unittest
from appium import webdriver
from time import sleep
from hover_pages.Firstlaunch_page import FirstLaunchPage

PATH = lambda p: os.path.abspath(
    os.path.join(os.path.dirname(__file__), p)
)

class TestHoverInstall(unittest.TestCase):
    def setUp(self):
        desired_capabilities = {}
        desired_capabilities['platformName'] = 'Android'
        desired_capabilities['deviceName'] = 'TWGDU16513002448'
        desired_capabilities['platformVersion'] = '6.0'
        desired_capabilities['app'] = PATH(
            '../apps/HoverCamera.apk'
        )
        desired_capabilities['appPackage'] = 'com.zerozero.hover'
        desired_capabilities['appActivity'] = '.newui.splash.SplashActivity'
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', desired_capabilities)
        # self.driver.implicitly_wait(5)

    def tearDown(self):
        self.driver.quit()

    def test_install_and_launch(self):
        print('testCase: install hover and Navigate to home page')
        self.assertTrue(self.driver.is_app_installed('com.zerozero.hover'), 'Install failed.')
        First_launch_page = FirstLaunchPage(self.driver)
        First_launch_page.accept_terms()
        First_launch_page.caution_confirm()
        First_launch_page.permission_allow()
        self.assertTrue(self.driver.current_activity == '.newui.home.HomeActivity', 'Fail to Navigate to home page.')

