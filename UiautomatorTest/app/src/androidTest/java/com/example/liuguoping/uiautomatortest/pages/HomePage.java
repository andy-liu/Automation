package com.example.liuguoping.uiautomatortest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.util.Log;

/**
 * Created by liuguoping on 2017/8/7.
 */

public class HomePage extends BasePage {
    public HomePage(UiDevice currentDevice) {
        super(currentDevice);
    }

    public String albumBtnId = "com.zerozero.hover:id/iv_album";
    public String albumCloseBtnId = "com.zerozero.hover:id/iv_activity_album2_close";
    public String settingsBtnId = "com.zerozero.hover:id/iv_settings";
    public String customerServiceBtnId = "com.zerozero.hover:id/iv_customer_service";
    public String customerServiceCloseBtnId = "com.zerozero.hover:id/back_rl";
    public String socialBtnId = "com.zerozero.hover:id/tv_month";
    public String socialCloseBtnId = "com.zerozero.hover:id/close";
    public String getStartBtnId = "com.zerozero.hover:id/btn_start";

    public boolean clickAblumBtn(){
        findElementById(albumBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickAblumCloseBtn(){
        findElementById(albumCloseBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickSettingsBtn(){
        findElementById(settingsBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickCustomerBtn(){
        findElementById(customerServiceBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickCustomerCloseBtn(){
        findElementById(customerServiceCloseBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickSocialBtn(){
        findElementById(socialBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickSocialCloseBtn(){
        findElementById(socialCloseBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickSceneByName(String sceneName){
        findElementByText(sceneName).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickGetStartBtn(){
        findElementById(getStartBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }
}
