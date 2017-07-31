# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: liuguoping
'''
import traceback
import unittest
from appium import webdriver
from time import sleep
from utils.common_function import is_element_exist

class TestPreviewOption(unittest.TestCase):
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
            
        def test_takephoto_manualcontrol(self):
            scene_list = self.driver.find_elements_by_id('com.zerozero.hover:id/tv_title')
            for scene in scene_list:
                if scene.get_attribute('text') == 'Manual Control':
                    scene.click()
                    break
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_start').click()
            self.driver.find_element_by_id('com.zerozero.hover:id/tutorial_start_btn').click()
            try:
                self.driver.find_element_by_id('com.zerozero.hover:id/caution_view_close').click()
            except Exception:
                traceback.print_exc()
            # make sure it is photo mode
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_camera_setting').click()
            if (not is_element_exist(self.driver, 'com.zerozero.hover:id/container_countdown')):
                self.driver.find_element_by_id('com.zerozero.hover:id/btn_camera_switch_video').click()
                sleep(3)
                
            camera_shutter = self.driver.find_element_by_id('com.zerozero.hover:id/btn_manual_shutter')
            for i in range(5):
                camera_shutter.click()
                sleep(5)
            self.driver.find_element_by_id('com.zerozero.hover:id/camera_close').click()
            sleep(5)
            self.driver.press_keycode(4)
        
        def test_switch_mode_manualcontrol(self):
            scene_list = self.driver.find_elements_by_id('com.zerozero.hover:id/tv_title')
            for scene in scene_list:
                if scene.get_attribute('text') == 'Manual Control':
                    scene.click()
                    break
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_start').click()
            self.driver.find_element_by_id('com.zerozero.hover:id/tutorial_start_btn').click()
            try:
                self.driver.find_element_by_id('com.zerozero.hover:id/caution_view_close').click()
            except Exception:
                traceback.print_exc()
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_camera_setting').click()
            if (is_element_exist(self.driver, 'com.zerozero.hover:id/container_countdown')):
                print ('it is photo mode now')
                self.driver.find_element_by_id('com.zerozero.hover:id/btn_camera_switch_video').click()
                sleep(3)
                self.driver.find_element_by_id('com.zerozero.hover:id/btn_camera_setting').click()
                self.assertFalse(is_element_exist(self.driver, 'com.zerozero.hover:id/container_countdown'), 'Fail to switch mode to video')
                self.driver.find_element_by_id('com.zerozero.hover:id/camera_close').click()
            else:
                print ('it is video mode now')
                self.driver.find_element_by_id('com.zerozero.hover:id/btn_camera_switch_video').click()
                sleep(3)
                self.driver.find_element_by_id('com.zerozero.hover:id/btn_camera_setting').click()
                self.assertTrue(is_element_exist(self.driver, 'com.zerozero.hover:id/container_countdown'), 'Fail to switch mode to photo')
                self.driver.find_element_by_id('com.zerozero.hover:id/camera_close').click()
                
        def test_takephoto_groupphoto(self):
            width = self.driver.get_window_size()['width']
            height = self.driver.get_window_size()['height']
            self.driver.swipe(int(width * 3/4), int(height * 15/16), int(width * 1/4), int(height * 15/16), 500)
            scene_list = self.driver.find_elements_by_id('com.zerozero.hover:id/tv_title')
            for scene in scene_list:
                if scene.get_attribute('text') == 'Group Photo':
                    scene.click()
                    break
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_start').click()
            self.driver.find_element_by_id('com.zerozero.hover:id/tutorial_start_btn').click()
            try:
                self.driver.find_element_by_id('com.zerozero.hover:id/caution_view_close').click()
            except Exception:
                traceback.print_exc()
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_camera_shutter').click()
            sleep(5)
            self.driver.find_element_by_id('com.zerozero.hover:id/camera_close').click()
            sleep(3)
            self.assertTrue(self.driver.find_elements_by_id('com.zerozero.hover:id/iv_thumb'), 'Fail to download photo in session')
            self.driver.press_keycode(4)
         
        def test_switch_scene(self):
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_start').click()
            self.driver.find_element_by_id('com.zerozero.hover:id/tutorial_btn_start_owner').click()
            try:
                self.driver.find_element_by_id('com.zerozero.hover:id/caution_view_close').click()
            except Exception:
                traceback.print_exc()
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_switch_scene').click()
            scene_list = self.driver.find_elements_by_id('com.zerozero.hover:id/item_switch_scene')
            for scene in scene_list:
                if scene.get_attribute('text') == 'Manual Control':
                    scene.click()
                    sleep(3)
                    break
            self.assertTrue(is_element_exist(self.driver, 'com.zerozero.hover:id/btn_camera_setting'), 'Fail to switch to Manual Control mode')           
            
            self.driver.find_element_by_id('com.zerozero.hover:id/btn_switch_scene').click()
            scene_list = self.driver.find_elements_by_id('com.zerozero.hover:id/item_switch_scene')
            for scene in scene_list:
                if scene.get_attribute('text') == 'Orbit':
                    scene.click()
                    sleep(3)
                    break
            self.assertTrue(is_element_exist(self.driver, 'com.zerozero.hover:id/start_spin_or_orbit'), 'Fail to switch to Orbit mode')
            self.driver.find_element_by_id('com.zerozero.hover:id/camera_close').click()
        
        def test_keycode(self):
            self.driver.press_keycode(4)
            self.driver.press_keycode(4)
            self.driver.launch_app()        
            
            
            
    