package com.zerozero.androidappautotestcases;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.zerozero.common.MyUtil;
import com.zerozero.page.HomePage;
import com.zerozero.page.TutorialPage;

import io.appium.java_client.android.AndroidDriver;

public class TestHomePage {
static AndroidDriver<WebElement> driver;

	@BeforeClass
	public static void setUp(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
		MyUtil.setCapabilityForNonFirstInstall(capabilities);
        try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.closeApp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before
	public void setup(){
		driver.launchApp();
	}
	
	@Test
	public void testElementsOfHomePage(){
		HomePage homePage = new HomePage();
		boolean homeTile = MyUtil.isElementExist(driver, homePage.homeTitle_Id);
		boolean imageViewBtn = MyUtil.isElementExist(driver, homePage.imageViewBtn_Id);
		boolean aibumBtn = MyUtil.isElementExist(driver, homePage.albumViewBtn_Id);
		boolean wifiBtn = MyUtil.isElementExist(driver, homePage.wifiBtn_Id);
		boolean tutorialBtn = MyUtil.isElementExist(driver, homePage.tutorialBtn_Id);
		boolean settingsBtn = MyUtil.isElementExist(driver, homePage.settingsBtn_Id);
		boolean instagramBtn = MyUtil.isElementExist(driver, homePage.instagramBtn_Id);
		boolean result = homeTile&&imageViewBtn&&aibumBtn&&wifiBtn&&tutorialBtn&&settingsBtn&&instagramBtn;
		assertTrue("element is missing", result);
	}
	
	@Test
	public void testNavToImageViewPage(){
		try {
			HomePage homePage = new HomePage();
			homePage.navToImageViewPage(driver);
//			System.out.println(driver.currentActivity());
			assertTrue("Fail to navgate to image view page!", driver.currentActivity().equals(".CameraActivity"));
			driver.navigate().back();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNavoToAlbumPage(){
		try {
			HomePage homePage = new HomePage();
			homePage.navToAlbumViewPage(driver);
			assertTrue("Fail to navgate to image view page!", driver.currentActivity().equals(".AlbumActivity"));
			driver.navigate().back();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNavToWifiPage(){
		try {
			HomePage homePage = new HomePage();
			homePage.navToWifiPage(driver);
			assertTrue("Fail to navgate to WifiSettings page of system!", driver.currentActivity().equals(".Settings$WifiSettingsActivity"));
			driver.navigate().back();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void testNavToTutorialPage() {
		try {
			HomePage homePage = new HomePage();
			homePage.navToTutorialPage(driver);
			assertTrue("Fail to navgate to Tutorial page!", driver.currentActivity().equals(".TutorialActivity"));
			driver.navigate().back();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNavToSettingsPage(){
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			assertTrue("Fail to navgate to settings page!", driver.currentActivity().equals(".SettingsBaseActivity"));
			driver.navigate().back();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@After
	public void teardown(){
		driver.closeApp();
	}
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}

}
