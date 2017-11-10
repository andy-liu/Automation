package uiautomatortestforoldversion;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class FirstUiautomatorTestCase extends UiAutomatorTestCase{
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
	public void testFirstLaunch() throws Exception{
		Runtime.getRuntime().exec("am start com.zerozero.hover/com.zerozero.hover.newui.splash.SplashActivity").waitFor();
		UiObject acceptTermsBtn = new UiObject(new UiSelector().text("Accept"));
		acceptTermsBtn.clickAndWaitForNewWindow(2000);
		UiObject cautionConfirmBtn = new UiObject(new UiSelector().resourceId("com.zerozero.hover:id/txt_check_page_btn_ok"));
		cautionConfirmBtn.clickAndWaitForNewWindow(2000);
		UiObject permitionAllowBtn = new UiObject(new UiSelector().resourceId("com.android.packageinstaller:id/permission_allow_button"));
		permitionAllowBtn.click();
		permitionAllowBtn.click();
	}
}
