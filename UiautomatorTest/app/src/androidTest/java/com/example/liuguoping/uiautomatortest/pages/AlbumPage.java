package com.example.liuguoping.uiautomatortest.pages;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import java.util.List;

/**
 * Created by liuguoping on 2017/8/9.
 */

public class AlbumPage extends BasePage {
    public AlbumPage(UiDevice mDevice) {
        super(mDevice);
    }

    public String closeAlbumBtnId = "com.zerozero.hover:id/iv_activity_album2_close";
    public String thumbnailId = "com.zerozero.hover:id/iv_thumb";
    public String backBtnId = "com.zerozero.hover:id/iv_back";

    public boolean clickCloseAlbumBtn(){
        findElementById(closeAlbumBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public boolean clickThumbnail(){
        findElementById(thumbnailId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }

    public List<UiObject2> getImageList(){
        return findElementsById(thumbnailId);
    }

    public boolean clickBackBtn(){
        findElementById(backBtnId).clickAndWait(Until.newWindow(), 2000);
        return true;
    }
}
