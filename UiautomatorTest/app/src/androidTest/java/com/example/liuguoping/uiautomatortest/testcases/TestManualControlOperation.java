package com.example.liuguoping.uiautomatortest.testcases;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by liuguoping on 2017/11/10.
 */

public class TestManualControlOperation extends BaseCase {
    private UiDevice mDevice = null;
    private Context mContext = null;

    @Before
    public void setUp() throws Exception{
        Log.i("setUp", "setUp");
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());  //获得device对象
        if(!mDevice.isScreenOn()){
            mDevice.wakeUp();//唤醒屏幕
            mDevice.swipe(mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() - 100, mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() / 2, 5);
        }
        mContext = InstrumentationRegistry.getContext();
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(myIntent);
    }

    @After
    public void tearDown() throws Exception{
        mDevice.executeShellCommand("am force-stop com.zerozero.hover");
        mDevice.sleep();
    }

    @Test
    public void testTakePhoto() throws Exception{
        
    }
}
