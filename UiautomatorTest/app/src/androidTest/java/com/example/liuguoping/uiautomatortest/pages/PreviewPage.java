package com.example.liuguoping.uiautomatortest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

/**
 * Created by liuguoping on 2017/11/10.
 */

public class PreviewPage extends BasePage {
    public PreviewPage(UiDevice currentDevice) {
        super(currentDevice);
    }
    String tutorialGoBtnId = "com.zerozero.hover:id/tutorial_start_btn";
    String cautionPageCloseBtnId = "com.zerozero.hover:id/caution_view_close";
    String cameraShutterBtnId = "com.zerozero.hover:id/btn_manual_shutter";
    String switchModeBtnId = "com.zerozero.hover:id/btn_camera_switch_video";
    String previewCloseBtnId = "com.zerozero.hover:id/camera_close";


    public boolean clickTutorialGoBtn(){
        findElementById(tutorialGoBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickCautionPageCloseBtn(){
        try {
            findElementById(cautionPageCloseBtnId).clickAndWait(Until.newWindow(), 2000);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean clickShutterBtn(){
        findElementById(cameraShutterBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickChangeModeBtn(){
        findElementById(switchModeBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickPreviewCloseBtn(){
        findElementById(previewCloseBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

}
