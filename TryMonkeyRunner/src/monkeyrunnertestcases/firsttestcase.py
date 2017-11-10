# -*- coding:utf-8 -*-
'''
Created on 2017年10月14日

@author: liuguoping
'''
from com.android.monkeyrunner import MonkeyRunner
from com.android.monkeyrunner import MonkeyDevice
from com.android.monkeyrunner import MonkeyImage
from com.android.monkeyrunner.easy import EasyMonkeyDevice  
from com.android.monkeyrunner.easy import By

device = MonkeyRunner.waitForConnection(6, 'emulator-5554')
device.installPackage('C:\\Users\\liuguoping\\Downloads\\app-product-release.apk')
device.startActivity(component='com.zerozero.hover/.newui.splash.SplashActivity')
easy_device = EasyMonkeyDevice(device)
easy_device.touch(By.id('com.zerozero.hovertest:id/btnCloseTerms'), MonkeyDevice.DOWN_AND_UP)

# device.press('KEYCODE_MENU', MonkeyDevice.DOWN_AND_UP)
# device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
device.press()