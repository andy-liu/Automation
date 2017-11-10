package com.example.liuguoping.uiautomatortest.testcases;

/**
 * Created by liuguoping on 2017/8/9.
 */
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import com.example.liuguoping.uiautomatortest.pages.AlbumPage;
import com.example.liuguoping.uiautomatortest.pages.HomePage;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class TestAlbumOperation extends BaseCase{
    private UiDevice mDevice = null;
    private Context mContext = null;
    @Before
    public void setUp () throws Exception{
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());  //获得device对象
        if(!mDevice.isScreenOn()){
            mDevice.wakeUp();
            mDevice.swipe(mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() -100,
                    mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() / 2, 5);
        }
        mContext = InstrumentationRegistry.getContext();
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(APP);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(myIntent);
    }

    @After
    public void tearDown() throws Exception{
        mDevice.executeShellCommand("am force-stop com.zerozero.hover");
        mDevice.sleep();
    }

    @Test
    public void testOpenImage() throws Exception{
        HomePage homePage = new HomePage(mDevice);
        AlbumPage albumPage = new AlbumPage(mDevice);
        homePage.clickAblumBtn();
        List<UiObject2> imageList = albumPage.getImageList();
        for(int i=0; i<imageList.size(); i++){
            imageList.get(i).clickAndWait(Until.newWindow(), 2000);
            albumPage.clickBackBtn();
        }
        albumPage.clickCloseAlbumBtn();
    }

    @Test
    public void testImageSwipe() throws Exception{
        HomePage homePage = new HomePage(mDevice);
        AlbumPage albumPage = new AlbumPage(mDevice);
        homePage.clickAblumBtn();
        albumPage.clickThumbnail();
        for(int i=0; i<6; i++){
            mDevice.swipe(mDevice.getDisplayWidth()*4/5, mDevice.getDisplayHeight()
                            /3,mDevice.getDisplayWidth() / 5, mDevice.getDisplayHeight() /3,
                    5);
        }
        albumPage.clickBackBtn();
        albumPage.clickCloseAlbumBtn();
    }
}
