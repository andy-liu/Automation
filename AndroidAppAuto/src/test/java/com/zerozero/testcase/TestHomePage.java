package com.zerozero.testcase;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.zerozero.common.MyUtil;
import com.zerozero.page.HomePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TestHomePage {
private AndroidDriver<WebElement> driver;

	@Before
	public void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
		MyUtil.setCapabilityForNonFirstInstall(capabilities);
        try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testElementsOfHomePage() {
		System.out.println("testCase: Check elements in Home Page");
		HomePage homePage = new HomePage();
		boolean imageViewBtn = MyUtil.isElementExist(driver, homePage.imageViewBtn_Id);
		boolean albumBtn = MyUtil.isElementExist(driver, homePage.albumViewBtn_Id);
		boolean wifiBtn = MyUtil.isElementExist(driver, homePage.wifiBtn_Id);
		boolean tutorialBtn = MyUtil.isElementExist(driver, homePage.tutorialBtn_Id);
		boolean settingsBtn = MyUtil.isElementExist(driver, homePage.settingsBtn_Id);
		boolean instagramBtn = MyUtil.isElementExist(driver, homePage.instagramBtn_Id);
		boolean result = imageViewBtn&&albumBtn&&wifiBtn&&tutorialBtn&&settingsBtn&&instagramBtn;
		assertTrue("element is missing", result);
	}
	
	@Test
	public void testNavigationOfHomePage(){
		System.out.println("testCase: Navigate to destination page from home page");
		try {
			HomePage homePage = new HomePage();
			homePage.navToImageViewPage(driver);

			assertTrue("Fail to navgate to image view page!", driver.currentActivity().equals(".CameraActivity"));
			driver.pressKeyCode(AndroidKeyCode.BACK);
			
			homePage.navToAlbumViewPage(driver);
			assertTrue("Fail to navgate to image view page!", driver.currentActivity().equals(".AlbumActivity"));
			driver.pressKeyCode(AndroidKeyCode.BACK);
			
			homePage.navToWifiPage(driver);
			assertTrue("Fail to navgate to WifiSettings page of system!", driver.currentActivity().equals(".Settings$WifiSettingsActivity"));
			driver.pressKeyCode(AndroidKeyCode.BACK);
			
			homePage.navToTutorialPage(driver);
			assertTrue("Fail to navgate to Tutorial page!", driver.currentActivity().equals(".TutorialActivity"));
			driver.pressKeyCode(AndroidKeyCode.BACK);
			
			homePage.navToSettingsPage(driver);
			assertTrue("Fail to navgate to settings page!", driver.currentActivity().equals(".SettingsBaseActivity"));
			driver.pressKeyCode(AndroidKeyCode.BACK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@After
	public void teardown(){
		driver.quit();
	}
}
