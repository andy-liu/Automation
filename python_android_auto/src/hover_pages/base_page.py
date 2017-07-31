# -*- coding:utf-8 -*-
from selenium.webdriver.support.expected_conditions import NoSuchElementException
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.support.ui import WebDriverWait


class BasePage(object):
    def __init__(self, driver):
        self.driver = driver

    def find_element(self, *loc):
        element = WebDriverWait(self.driver, 5).until(lambda driver: driver.find_element(*loc))
        return element

    def find_elements(self, *loc):
        element = WebDriverWait(self.driver, 5).until(lambda driver: driver.find_elements(*loc))
        return element

    def is_element_exist(self, *loc):
        try:
            element = WebDriverWait(self.driver, 5).until(lambda driver: driver.find_elements(*loc))
            return True
        except Exception:
            return False

    def get_window_size(self):
        return self.driver.get_window_size()