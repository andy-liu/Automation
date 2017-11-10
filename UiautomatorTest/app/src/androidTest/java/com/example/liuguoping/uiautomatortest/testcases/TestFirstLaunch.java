package com.example.liuguoping.uiautomatortest.testcases;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import com.example.liuguoping.uiautomatortest.myutils.MyUiWatcher;
import com.example.liuguoping.uiautomatortest.pages.FirstLaunchPage;
import com.example.liuguoping.uiautomatortest.pages.HomePage;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by liuguoping on 2017/8/8.
 */
@RunWith(AndroidJUnit4.class)
public class TestFirstLaunch extends BaseCase{
    private UiDevice mDevice = null;
    private Context mContext = null;

    @Before
    public void setUp() throws Exception{
        Log.i("setUp", "setUp");
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());  //获得device对象
        if(!mDevice.isScreenOn()){
            mDevice.wakeUp();
        }
        mDevice.swipe(mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() - 100, mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() / 2, 5);
        mContext = InstrumentationRegistry.getContext();
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(myIntent);
    }

    @After
    public void tearDown() throws Exception{
        Log.i("tearDown", "tearDown");
        mDevice.executeShellCommand("am force-stop com.zerozero.hover");
        mDevice.sleep();
    }

    @Test
    public void testFirstLaunch() throws Exception{
        MyUiWatcher myUiWatcher = new MyUiWatcher(mDevice);
        mDevice.registerWatcher("testWatcher", myUiWatcher);
        FirstLaunchPage firstLaunchPage = new FirstLaunchPage(mDevice);
        HomePage homePage = new HomePage(mDevice);
        firstLaunchPage.clickAcceptBtn();
        Assert.assertTrue("Fail to pass", firstLaunchPage.isElementExist(homePage.albumBtnId,
                "id"));
    }
}
