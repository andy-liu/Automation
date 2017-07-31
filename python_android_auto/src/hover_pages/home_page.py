# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日
@author: liuguoping
'''
from selenium.webdriver.common.by import By
from hover_pages.base_page import BasePage
import traceback

class HomePage(BasePage):
    album_button = (By.ID, 'com.zerozero.hover:id/iv_album')
    settings_button = (By.ID, 'com.zerozero.hover:id/iv_settings')
    social_button = (By.ID, 'com.zerozero.hover:id/tv_month')
    switch_wifi_band_confirm_button = (By.ID, 'com.zerozero.hover:id/hint_confirm')
    switch_wifi_band_cancel_button = (By.ID, 'com.zerozero.hover:id/hint_cancel')
    ok_button_after_cancel = (By.ID, 'com.zerozero.hover:id/hint_confirm')

    get_start_button = (By.ID, 'com.zerozero.hover:id/btn_start')
    scenes_option = (By.ID, 'com.zerozero.hover:id/tv_title')
    scenes_lock_icon = (By.ID, 'com.zerozero.hover:id/iv_lock')
    scenes_name = ['Owner Mode', 'Manual Control', 'Group Photo', 'Bird\'s Eye',\
                   'Running', 'Cycling', 'Orbit', '360 Spin']
    #home和preview之间的过渡页
    ownermode_go_button = (By.ID, 'com.zerozero.hover:id/tutorial_btn_start_owner')
    caution_close_button = (By.ID, 'com.zerozero.hover:id/caution_view_close')

    def nav_to_album(self):
        self.find_element(*self.album_button).click()

    def nav_to_settings(self):
        self.find_element(*self.settings_button).click()

    def nav_to_social(self):
        self.find_element(*self.social_button).click()

    def scene_unlock(self):
        self.find_element(*self.get_start_button).click()
        self.find_element(*self.ownermode_go_button).click()
        try:
            self.find_element(*self.caution_close_button).click()
        except Exception:
            traceback.print_exc()
        self.driver.press_keycode(4)

    def is_scene_lock(self):
        if(self.is_element_exist(*self.scenes_lock_icon)):
            return True
        else:
            return False