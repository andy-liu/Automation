package com.example.liuguoping.uiautomatortest.testcases;

import android.content.Context;
import android.content.Intent;
import android.support.test.uiautomator.UiDevice;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.liuguoping.uiautomatortest.myutils.MyUiWatcher;
import com.example.liuguoping.uiautomatortest.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestHomeOperation extends BaseCase{
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
    public void testNavigationOfHome() throws Exception {
//        targetComtext = InstrumentationRegistry.getTargetContext();
        MyUiWatcher myUiWatcher = new MyUiWatcher(mDevice);
        mDevice.registerWatcher("testWatcher", myUiWatcher);
        HomePage homePage = new HomePage(mDevice);
        homePage.clickAblumBtn();
        homePage.clickAblumCloseBtn();
        homePage.clickSettingsBtn();
        mDevice.pressBack();
        homePage.clickCustomerBtn();
        homePage.clickCustomerCloseBtn();
        homePage.clickSocialBtn();
        homePage.clickSocialCloseBtn();
        Assert.assertTrue("Fail to back to Home page", homePage.isElementExist(homePage
                .albumBtnId, "id"));
    }
}
