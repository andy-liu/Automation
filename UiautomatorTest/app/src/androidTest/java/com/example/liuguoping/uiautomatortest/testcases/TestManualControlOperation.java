package com.example.liuguoping.uiautomatortest.testcases;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import com.example.liuguoping.uiautomatortest.myutils.MyUiWatcher;
import com.example.liuguoping.uiautomatortest.pages.EndSessionPage;
import com.example.liuguoping.uiautomatortest.pages.HomePage;
import com.example.liuguoping.uiautomatortest.pages.PreviewPage;

import org.junit.After;
import org.junit.Assert;
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
        MyUiWatcher myUiWatcher = new MyUiWatcher(mDevice);
        mDevice.registerWatcher("testWatcher", myUiWatcher);
        HomePage homePage = new HomePage(mDevice);
        PreviewPage previewPage = new PreviewPage(mDevice);
        EndSessionPage endSessionPage = new EndSessionPage(mDevice);
        homePage.clickSceneByName("Manual Control");
        homePage.clickGetStartBtn();
        previewPage.clickTutorialGoBtn();
        previewPage.clickCautionPageCloseBtn();
        previewPage.clickShutterBtn();
        previewPage.clickChangeModeBtn();
        previewPage.clickPreviewCloseBtn();
        Thread.sleep(3000);
        Assert.assertTrue("Fail to download photo.", 1==endSessionPage.getResourceCount());
        endSessionPage.clickSessionCloseBtn();
    }
}
