package com.zerozero.AndroidAppAutoTestCases;

import static org.junit.Assert.*;

import java.util.List;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.zerozero.common.MyUtil;
import com.zerozero.page.HomePage;
import com.zerozero.page.SettingsPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TestSettings {
	private AndroidDriver<WebElement> driver;
	@Before
	public void setUp(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		MyUtil.setCapabilityForNonFirstInstall(capabilities);
		
        try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testAboutPage() {
		System.out.println("testCase: jump to about page and check the terms link");
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.navToAboutPage(driver);
			String termsLink = driver.findElements(By.className(settingsPage.commonElement_class)).get(7).getText();
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);//back to home page
			assertTrue("Fail to navto about page", termsLink.equals(settingsPage.termsLinkText));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBeastMode(){
		System.out.println("testCase: jump to BeastMode and change beast mode!");
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.navToBeastModePage(driver);
			WebElement beastModeBtn = driver.findElement(By.id(settingsPage.beastMode_id));
			String before = beastModeBtn.getAttribute("checked");
			beastModeBtn.click();
			String after = beastModeBtn.getAttribute("checked");
			boolean resultAfterClicked = !before.equals(after);
			settingsPage.backToLastPage(driver);
			settingsPage.navToBeastModePage(driver);
			String last = beastModeBtn.getAttribute("checked");
			boolean resultCheckAgain = last.equals(after);
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Status of beast mode is not changed after clicked.", resultAfterClicked);
			assertTrue("Status of beast mode can not be maintained.", resultCheckAgain);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	@Test
	public void testDefaultRecordVideoSettings(){
		System.out.println("testCase: jump to RecordVideo page and check the default settings");
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.navToRecordVideoPage(driver);
			String resultOfResolution = driver.findElements(By.id(settingsPage.resolutionOption_id)).get(1).getAttribute("checked");
			String resultOfAutoVideoRecord = driver.findElement(By.id(settingsPage.autoVideoRecord_id)).getAttribute("checked");
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Default status of resolution is incorrect!", resultOfResolution.equals("true"));
			assertTrue("Default status of auto video record is incorrect!", resultOfAutoVideoRecord.equals("true"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRecordVideoSettings(){
		System.out.println("testCase: jump to RecordVideo and change the status of resolution and auto video record");
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.navToRecordVideoPage(driver);
			
			WebElement resolutionOptionOf4K = driver.findElements(By.id(settingsPage.resolutionOption_id)).get(2);
			resolutionOptionOf4K.click(); //change resolution to 4K
			
			WebElement autoVideoRecord = driver.findElement(By.id(settingsPage.autoVideoRecord_id));
			String statusOfAutoVideoRecordBeforeChanged = autoVideoRecord.getAttribute("checked");
			autoVideoRecord.click();//change the status of auto video record
			
			settingsPage.backToLastPage(driver);
			settingsPage.navToRecordVideoPage(driver);
			boolean resultOfChangeResolution = resolutionOptionOf4K.getAttribute("checked").equals("true");
			boolean resultOfChangeAutoVideoRecord = !autoVideoRecord.getAttribute("checked").equals(statusOfAutoVideoRecordBeforeChanged);
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Fail to change resolution to 4K", resultOfChangeResolution);
			assertTrue("Fail to change the status of auto video record", resultOfChangeAutoVideoRecord);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testWaterMark(){
		System.out.println("testCase: jump to WaterMark page and change the status of WaterMark");
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.navToWatermarkPage(driver);
			WebElement waterMarkBtn = driver.findElement(By.id(settingsPage.waterMark_id));
			String before = waterMarkBtn.getAttribute("checked");
			waterMarkBtn.click();
			String after = waterMarkBtn.getAttribute("checked");
			boolean resultAfterClicked = !before.equals(after);
			settingsPage.backToLastPage(driver);
			settingsPage.navToWatermarkPage(driver);
			String last = waterMarkBtn.getAttribute("checked");
			boolean resultCheckAgain = last.equals(after);
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Status of water mark is not changed after clicked.", resultAfterClicked);
			assertTrue("Status of water mark can not be maintained.", resultCheckAgain);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeWifiBand(){
		System.out.println("testCase: Change wifi to 2.4GHz or 5GHz");
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.navToSetWifiPage(driver);
			driver.findElement(By.id(settingsPage.wifiFrequencyBand_id)).click();
			List<WebElement> wifiBandOption = driver.findElements(By.id(settingsPage.wifiOption_id));
			if(wifiBandOption.get(0).getAttribute("checked").equals("true"))
				wifiBandOption.get(1).click();
			else
				wifiBandOption.get(0).click();
			driver.findElement(By.id(settingsPage.wifiBandChangeBtn_id)).click();
			WebElement changeConfirm = driver.findElement(By.id(settingsPage.wifiBandChangeConfirm_id));
			changeConfirm.click();
			String resultTextAfterChanged = driver.findElement(By.id(settingsPage.resultTextAfterChangeWifiBand_id)).getText();
			changeConfirm.click();
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Fail to change wifi band", resultTextAfterChanged.equals(settingsPage.resultTextAfterChangeWifiBand));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangeWifiInfo(){
		System.out.println("testCase: Change wifi info: name and password");
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.navToSetWifiPage(driver);
			settingsPage.changeWifiName(driver, "testAppiumUIAutomation");
			settingsPage.changeWifiPassword(driver, "12345678");
			driver.findElement(By.id(settingsPage.wifiInfoChangeBtn_id)).click();
			String resultTextAfterChanged = driver.findElement(By.id(settingsPage.resultTextAfterChangeWifiInfo_id)).getText();
			driver.findElement(By.id(settingsPage.resultAlertAfterChangeWifiInfoBtn_id)).click();
			settingsPage.backToLastPage(driver);
			assertTrue("Fail to change wifi info", resultTextAfterChanged.equals(settingsPage.resultTextAfterChangeWifiInfo_2)||resultTextAfterChanged.equals(settingsPage.resultTextAfterChangeWifiInfo_2));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	@Test
	public void TestTutorial(){
		System.out.println("testCase: jump to tutorial page from settings page and swipe the tutorial page");
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			settingsPage.navToTutorialPage(driver);
			boolean resultOfNavToTutorialPage = driver.currentActivity().equals(".TutorialActivity");
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
	   	 	for(int i=0; i<5; i++){
	   		 driver.swipe(width*6/7, height/2, width*1/7, height/2, 500);
	   	 	}
	   	 	driver.findElement(By.id("com.zerozero.hover:id/enjoy")).click();
	   	 	boolean resultOfBackFromTutorialPage = driver.currentActivity().equals(".SettingsBaseActivity");
	   	 	settingsPage.backToLastPage(driver);
	   	 	assertTrue("Fail to nav to tutorial page", resultOfNavToTutorialPage);
	   	 	assertTrue("Fail to back from tutorial page", resultOfBackFromTutorialPage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testDemo(){
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage = new SettingsPage();
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.swipe(width/2, height/4, width/2, height*3/4, 500);
			driver.swipe(width/2, height/4, width/2, height*3/4, 500);
			driver.swipe(width/2, height/4, width/2, height*3/4, 500);
//			Thread.sleep(5000);
//			driver.findElement(By.id(settingsPage.twitterLink_id)).click();
			List<WebElement> list = driver.findElements(By.className(settingsPage.commonElement_class));
			System.out.println(list.size());
			System.out.println(list.get(list.size()-1).getText());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

}
