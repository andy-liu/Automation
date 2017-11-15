package com.example.liuguoping.uiautomatortest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import java.util.List;

/**
 * Created by liuguoping on 2017/11/10.
 */

public class EndSessionPage extends BasePage {
    public EndSessionPage(UiDevice currentDevice){
        super(currentDevice);
    }

    public String sessionCloseBtnId = "com.zerozero.hover:id/close";
    public String createMovieBtnId = "com.zerozero.hover:id/floating_btn";
    public String resourceThumbId = "com.zerozero.hover:id/iv_thumb";

    public boolean clickSessionCloseBtn(){
        findElementById(sessionCloseBtnId).clickAndWait(Until.newWindow(),2000);
        return true;
    }

    public int getResourceCount(){
        List<UiObject2> resourceList = findElementsById(resourceThumbId);
        Log.i("getResourceCount", Integer.toString(resourceList.size()));
        return resourceList.size();
    }
}
