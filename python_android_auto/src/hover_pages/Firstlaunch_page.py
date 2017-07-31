# -*- coding:utf-8 -*-
'''
Created on 2017年6月15日

@author: liuguoping
'''
from selenium.webdriver.common.by import By
from hover_pages.base_page import BasePage


class FirstLaunchPage(BasePage):
    accept_terms_button = (By.CLASS_NAME, 'android.widget.Button')
    close_terms_button = (By.ID, 'com.zerozero.hover:id/btnCloseTerms')
    caution_confirm_button = (By.ID, 'com.zerozero.hover:id/txt_check_page_btn_ok')
    #samsung and huawei
    permission_allow_button = (By.ID, 'com.android.packageinstaller:id/permission_allow_button')

    def accept_terms(self):
        self.find_elements(*self.accept_terms_button)[0].click()

    def caution_confirm(self):
        self.find_element(*self.caution_confirm_button).click()

    def permission_allow(self):
        self.find_element(*self.permission_allow_button).click()
        self.find_element(*self.permission_allow_button).click()