package com.example.liuguoping.uiautomatortest.pages;

import android.support.test.uiautomator.UiDevice;

/**
 * Created by liuguoping on 2017/8/8.
 */

public class FirstLaunchPage extends BasePage{
    public FirstLaunchPage(UiDevice mDevice){
        super(mDevice);
    }

    //terms page
    public String acceptBtnClassName = "android.widget.Button";
    public String acceptBtnTxt = "Accept";
    public String closeBtnId = "com.zerozero.hover:id/btnCloseTerms";

    public String cautionConfirmId = "com.zerozero.hover:id/txt_check_page_btn_ok";

    public String permissionAllowBtnId = "com.android.packageinstaller:id/permission_allow_button";
    public String permissionDenyBtnId = "com.android.packageinstaller:id/permission_deny_button";

    public boolean clickAcceptBtn(){
        findElementByText(acceptBtnTxt).click();
        return true;
    }

    public boolean clickCautionConfirmBtn(){
        findElementById(cautionConfirmId).click();
        return true;
    }

    public boolean clickPermissingAllowBtn(){
        findElementById(permissionAllowBtnId).click();
        return true;
    }
}
