# -*- coding:utf-8 -*-
'''
Created on 2017年7月4日

@author: liuguoping
'''
import os
import unittest
import time
import random
import HTMLTestRunner
from utils.email_option import send_email_with_attach

from test_cases.test_home_opration import TestHomeOption
from test_cases.test_hover_install import TestHoverInstall
from test_cases.test_preview_opration import TestPreviewOption
from test_cases.test_album_opration import TestAlbumOption

if __name__ == '__main__':
    ISOTIMEFORMAT = '%Y-%m-%d'
    testunit=unittest.TestSuite()
    testunit.addTest(TestHoverInstall('test_install_and_launch'))
    
    testunit.addTest(TestHomeOption('test_navigate_from_home'))
    
    testunit.addTest(TestPreviewOption('test_scene_unlock'))
    testunit.addTest(TestPreviewOption('test_takephoto_manualcontrol'))
    testunit.addTest(TestPreviewOption('test_takephoto_groupphoto'))
    testunit.addTest(TestPreviewOption('test_switch_scene'))
    
    testunit.addTest(TestAlbumOption('test_delete_image_album'))
    testunit.addTest(TestAlbumOption('test_delete_image_preview_album'))
    
#     runner = unittest.TextTestRunner()
#     runner.run(testunit)
    filepath = r"D:\python_appium_report\Hover_Appium_Auto_" + time.strftime(ISOTIMEFORMAT, time.localtime()) +\
     '+'+ str(random.randint(1000, 2000)) + ".html"   #定义个报告存放路径，支持相对路径。
    filename = os.path.split(filepath)[1]
    with open(filepath,'wb') as fp:
        runner = HTMLTestRunner.HTMLTestRunner(stream=fp,title='Hover_Appium_Automation_Summary', \
                                           description='Android_UI_Automation')  #使用HTMLTestRunner配置参数，输出报告路径、报告标题、描述
        runner.run(testunit)
    if (send_email_with_attach('liuguoping@zerozero.cn', filepath, filename)):
        print ('Succeed to send html report!')
    else:
        print ('Failed to send html report!')
    
    
    
    
    