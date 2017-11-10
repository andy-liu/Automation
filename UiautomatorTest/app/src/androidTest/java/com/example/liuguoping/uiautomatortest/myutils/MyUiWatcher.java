package com.example.liuguoping.uiautomatortest.myutils;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

/**
 * Created by liuguoping on 2017/8/31.
 */

public class MyUiWatcher implements UiWatcher{
    private UiDevice mDevice;
    public MyUiWatcher(UiDevice myDevice){
        mDevice = myDevice;
    }
    @Override
    public boolean checkForCondition() {
        if(mDevice.hasObject(By.text("ALLOW"))){
            Log.i("UiWatcher", "触发watcher");
            mDevice.findObject(By.text("ALLOW")).click();
            return true;
        }
        else if(mDevice.hasObject(By.text("No Internet access"))){
            mDevice.findObject(By.res("android:id/button2")).click();
            return true;
        }
        else
            Log.i("UiWatcher", "未触发watcher");
        return false;
    }
}
