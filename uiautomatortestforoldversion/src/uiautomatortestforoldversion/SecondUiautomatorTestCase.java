package uiautomatortestforoldversion;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class SecondUiautomatorTestCase extends UiAutomatorTestCase{
	private UiDevice mDevice;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("setUp!");
		mDevice = getUiDevice();
    	if(!mDevice.isScreenOn()){
    		mDevice.wakeUp();
			mDevice.swipe(mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() - 100, mDevice.getDisplayWidth() / 2, mDevice.getDisplayHeight() / 2, 5);
    	}
	}
	
	@After
	public void tearDown() throws Exception{
		Runtime.getRuntime().exec("am force-stop com.zerozero.hover").waitFor();
		mDevice.sleep();
	}
	
	@Test
    public void testNavOfHomePage() throws Exception{
    	Runtime.getRuntime().exec("am start com.zerozero.hover/com.zerozero.hover.newui.splash.SplashActivity").waitFor();
    	UiObject albumBtn = new UiObject(new UiSelector().resourceId("com.zerozero.hover:id/iv_album"));
    	albumBtn.clickAndWaitForNewWindow(2000);
    	UiObject closeAlbumBtn = new UiObject(new UiSelector().resourceId("com.zerozero.hover:id/iv_activity_album2_close"));
    	closeAlbumBtn.clickAndWaitForNewWindow(2000);
    	
    	UiObject settingsBtn = new UiObject(new UiSelector().resourceId("com.zerozero.hover:id/iv_settings"));
    	settingsBtn.clickAndWaitForNewWindow(2000);
    	mDevice.pressBack();
    	
    	UiObject socialHubBtn = new UiObject(new UiSelector().resourceId("com.zerozero.hover:id/tv_month"));
    	socialHubBtn.clickAndWaitForNewWindow(2000);
    	UiObject closeSocialBtn = new UiObject(new UiSelector().resourceId("com.zerozero.hover:id/close"));
    	closeSocialBtn.clickAndWaitForNewWindow(2000);
    	boolean result = true;
    	try {
    		new UiObject(new UiSelector().resourceId("com.zerozero.hover:id/iv_album")).click();
		} catch (UiObjectNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		}
    	assertTrue("Fail to back to home page.", result);
    }


}
