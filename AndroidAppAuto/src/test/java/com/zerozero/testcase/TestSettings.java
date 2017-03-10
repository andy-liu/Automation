package com.zerozero.testcase;

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
import com.zerozero.page.TutorialPage;

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
			String termsLink = driver.findElement(By.id(settingsPage.termsLink_id)).getText();
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);//back to home page
			assertTrue("Fail to navto about page", termsLink.equals(settingsPage.termsLinkText));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFirmwareUpdate(){
		try {
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			settingsPage.navToFirmwareUpdatePage(driver);
//			System.out.println(driver.findElements(By.className(settingsPage.commonElement_class)).get(0).getText());
			boolean resultOfFirmwareUpdatePage = driver.findElements(By.className(settingsPage.commonElement_class)).get(0).getText().equals("Firmware Update");
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Fail to go to Firmware update page!", resultOfFirmwareUpdatePage);
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMemoryManagement(){
		try {
			MyUtil.connectToCameraWifiIfNot(driver);
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			settingsPage.navToMemoryManagePage(driver);
			WebElement formatMemoryBtn = driver.findElement(By.id(settingsPage.formatMemoryBtn_id));
			boolean before = formatMemoryBtn.isDisplayed();
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.swipe(width*3/4, height/2, width*1/4, height/2, 500);
			driver.swipe(width*3/4, height/2, width*1/4, height/2, 500);
			driver.swipe(width*1/4, height/2, width*3/4, height/2, 500);
			driver.swipe(width*1/4, height/2, width*3/4, height/2, 500);
			boolean after = formatMemoryBtn.isDisplayed();
			driver.navigate().back();
			settingsPage.backToLastPage(driver);
			assertTrue("Format memory button is missing!", before&&after);
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
	}
	
	@Test
	public void testDownloadPhotoFromMemory(){
		System.out.println("testCase: Download photo from memory!");
		try {
			MyUtil.connectToCameraWifiIfNot(driver);
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			settingsPage.navToMemoryManagePage(driver);
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.swipe(width*3/4, height/2, width*1/4, height/2, 500);
			List<WebElement> photoListOfNotDownload = driver.findElements(By.id(settingsPage.imageOfNotDownload_id));
			photoListOfNotDownload.get(0).click();
			Thread.sleep(8000);//waiting for the downloading process
			List<WebElement> photoListOfNotDownloadAfter = driver.findElements(By.id(settingsPage.imageOfNotDownload_id));
			assertTrue("Fail to download photo in memory page!", photoListOfNotDownload.size()-photoListOfNotDownloadAfter.size()==1);
			driver.navigate().back();
			settingsPage.backToLastPage(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFormatMemory(){
		System.out.println("testCase: Format memory");
		try {
			MyUtil.connectToCameraWifiIfNot(driver);
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			settingsPage.navToMemoryManagePage(driver);
			WebElement formatMemoryBtn = driver.findElement(By.id(settingsPage.formatMemoryBtn_id));
			formatMemoryBtn.click();
			driver.findElement(By.id(settingsPage.formatAlertCancel_id)).click();
			formatMemoryBtn.click();
			driver.findElement(By.id(settingsPage.formatAlertConfirm_id)).click();
			driver.findElement(By.id(settingsPage.formatAlertConfirm_id)).click();
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.swipe(width*3/4, height/2, width*1/4, height/2, 500);
			WebElement photoEmptyStatus = driver.findElement(By.id(settingsPage.emptyStatus_id));
			driver.swipe(width*3/4, height/2, width*1/4, height/2, 500);
			WebElement videoEmptyStatus = driver.findElement(By.id(settingsPage.emptyStatus_id));
			assertTrue("Fail to format memory!", photoEmptyStatus.isDisplayed()&&videoEmptyStatus.isDisplayed());
			driver.navigate().back();
			settingsPage.backToLastPage(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeletePhotoInMemory(){
		System.out.println("testCase: test delete photo in memory");
		try {
			MyUtil.connectToCameraWifiIfNot(driver);
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			settingsPage.navToMemoryManagePage(driver);
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.swipe(width*3/4, height/2, width*1/4, height/2, 500);
			if(MyUtil.isElementExist(driver, settingsPage.imageOfNotDownload_id)){
				List<WebElement> photoListOfNotDownload = driver.findElements(By.id(settingsPage.imageOfNotDownload_id));
				int countBeforeDelete = photoListOfNotDownload.size();
				driver.tap(1, photoListOfNotDownload.get(0), 1000);
				if(photoListOfNotDownload.size()>1)
					photoListOfNotDownload.get(1).click();
				settingsPage.deleteResourceFromMemory(driver);
				int countAfterDelete = driver.findElements(By.id(settingsPage.imageOfNotDownload_id)).size();
				assertTrue("Fail to delete photo which is not downloaded!", countBeforeDelete-countAfterDelete > 0);
			}
			else
				System.out.println("No photo which is not downloaded!");
			if(MyUtil.isElementExist(driver, settingsPage.imageOfDownloaded_id)){
				List<WebElement> photoListOfDownload = driver.findElements(By.id(settingsPage.imageOfDownloaded_id));
				int countBeforeDelete = photoListOfDownload.size();
				driver.tap(1, photoListOfDownload.get(0), 1000);
				if(photoListOfDownload.size()>1)
					photoListOfDownload.get(1).click();
				settingsPage.deleteResourceFromMemory(driver);
				int countAfterDelete = driver.findElements(By.id(settingsPage.imageOfDownloaded_id)).size();
				assertTrue("Fail to delete photo which is downloaded!", countBeforeDelete-countAfterDelete > 0);
			}
			else
				System.out.println("No photo which is downloaded!");
			driver.navigate().back();
			settingsPage.backToLastPage(driver);
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testDeleteVideoInMemory(){
		System.out.println("testCase: test delete video in memory");
		try {
			MyUtil.connectToCameraWifiIfNot(driver);
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			settingsPage.navToMemoryManagePage(driver);
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.swipe(width*3/4, height/2, width*1/4, height/2, 500);
			driver.swipe(width*3/4, height/2, width*1/4, height/2, 500);
			if(MyUtil.isElementExist(driver, settingsPage.imageOfNotDownload_id)){
				List<WebElement> photoListOfNotDownload = driver.findElements(By.id(settingsPage.imageOfNotDownload_id));
				int countBeforeDelete = photoListOfNotDownload.size();
				driver.tap(1, photoListOfNotDownload.get(0), 1000);
				if(photoListOfNotDownload.size()>1)
					photoListOfNotDownload.get(1).click();
				settingsPage.deleteResourceFromMemory(driver);
				int countAfterDelete = driver.findElements(By.id(settingsPage.imageOfNotDownload_id)).size();
				assertTrue("Fail to delete video which is not downloaded!", countBeforeDelete-countAfterDelete > 0);
			}
			else
				System.out.println("No video which is not downloaded!");
			if(MyUtil.isElementExist(driver, settingsPage.imageOfDownloaded_id)){
				List<WebElement> photoListOfDownload = driver.findElements(By.id(settingsPage.imageOfDownloaded_id));
				int countBeforeDelete = photoListOfDownload.size();
				driver.tap(1, photoListOfDownload.get(0), 1000);
				if(photoListOfDownload.size()>1)
					photoListOfDownload.get(1).click();
				settingsPage.deleteResourceFromMemory(driver);
				int countAfterDelete = driver.findElements(By.id(settingsPage.imageOfDownloaded_id)).size();
				assertTrue("Fail to delete video which is downloaded!", countBeforeDelete-countAfterDelete > 0);
			}
			else
				System.out.println("No video which is downloaded!");
			driver.navigate().back();
			settingsPage.backToLastPage(driver);
				
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
			WebElement waterMarPhotoBtn = driver.findElement(By.id(settingsPage.waterMarkPhoto_id));
			WebElement waterMarkVideoBtn = driver.findElement(By.id(settingsPage.waterMarkVideo_id));
			String before = waterMarPhotoBtn.getAttribute("checked");
			String beforeOfVideo = waterMarkVideoBtn.getAttribute("checked");
			waterMarPhotoBtn.click();
			waterMarkVideoBtn.click();
			String after = waterMarPhotoBtn.getAttribute("checked");
			String afterOfVideo = waterMarkVideoBtn.getAttribute("checked");
			boolean resultAfterClicked = !before.equals(after);
			boolean resultAfterClickedOfVideo = !beforeOfVideo.equals(afterOfVideo);
			settingsPage.backToLastPage(driver);
			settingsPage.navToWatermarkPage(driver);
			String last = waterMarPhotoBtn.getAttribute("checked");
			String lastOfVideo = waterMarkVideoBtn.getAttribute("checked");
			boolean resultCheckAgain = last.equals(after);
			boolean resultCheckAgainOfVideo = lastOfVideo.equals(afterOfVideo);
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Status of watermark-photo is not changed after clicked.", resultAfterClicked);
			assertTrue("Status of watermark-photo can not be maintained.", resultCheckAgain);
			assertTrue("Status of watermark-video is not changed after clicked.", resultAfterClickedOfVideo);
			assertTrue("Status of watermark-video can not be maintained.", resultCheckAgainOfVideo);
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
	public void testFactoryReset(){
		System.out.println("testCase: check factory reset page!");
		try {
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			MyUtil.connectToCameraWifiIfNot(driver);
			homePage.navToSettingsPage(driver);
			settingsPage.navToFactoryResetPage(driver);
			boolean resultOfFactoryResetPage = driver.findElement(By.id(settingsPage.factoryResetBtn_id)).isDisplayed();		
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Factory reset button is missing!", resultOfFactoryResetPage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHelpCenter(){
		System.out.println("testCase: Jump to help canter page from settings page!");
		try {
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			settingsPage.navToHelpCenterPage(driver);
			boolean resulltOfClickHelpCenter = driver.currentActivity().equals(".WebViewActivity");
			settingsPage.backToLastPage(driver);
			settingsPage.backToLastPage(driver);
			assertTrue("Fail to jump to help center page!", resulltOfClickHelpCenter);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFeedBack(){
		System.out.println("testCase: Show feedback options in settings page!");
		try {
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			settingsPage.navToSupportFeedbackPage(driver);
			WebElement cancelBtn = driver.findElement(By.id(settingsPage.cancelBtn_id));
			boolean resultOfClickFeedBack = driver.findElement(By.id(settingsPage.reportProblem_id)).isDisplayed() &&
			driver.findElement(By.id(settingsPage.generalFeedBack_id)).isDisplayed()
			&&driver.findElement(By.id(settingsPage.sendLog_id)).isDisplayed()&&cancelBtn.isDisplayed();
			cancelBtn.click();
			settingsPage.backToLastPage(driver);
			assertTrue("Fail to show feedback options!", resultOfClickFeedBack);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testJumpToTutorial(){
		System.out.println("testCase: jump to tutorial page from settings page and swipe the tutorial page");
		try {
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			TutorialPage tutorialPage = new TutorialPage();
			homePage.navToSettingsPage(driver);
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			settingsPage.navToTutorialPage(driver);
			boolean resultOfNavToTutorialPage = driver.currentActivity().equals(".TutorialActivity");
	   	 	for(int i=0; i<5; i++){
	   		 driver.swipe(width*6/7, height/2, width*1/7, height/2, 500);
	   	 	}
	   	 	driver.findElement(By.id(tutorialPage.enjoyBtn_id)).click();
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
	public void testSocialNetwork(){
		System.out.println("testCase: check options of social network!");
		try {
			HomePage homePage = new HomePage();
			SettingsPage settingsPage = new SettingsPage();
			homePage.navToSettingsPage(driver);
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.swipe(width/2, height*3/4, width/2, height/4, 500);
			WebElement facebookOption = driver.findElement(By.id(settingsPage.faceBookLink_id));
			WebElement twitterOption = driver.findElement(By.id(settingsPage.twitterLink_id));
			WebElement instagramOption = driver.findElement(By.id(settingsPage.instagramLink_id));
			WebElement wechatOption = driver.findElement(By.id(settingsPage.wechatLink_id));
			WebElement weiboOption = driver.findElement(By.id(settingsPage.weiboLink_id));
			boolean resultOfCheckSocialNet = facebookOption.isDisplayed()&&twitterOption.isDisplayed()
					&&instagramOption.isDisplayed()&&wechatOption.isDisplayed()&&weiboOption.isDisplayed();
			settingsPage.backToLastPage(driver);
			assertTrue("Social options are missing!", resultOfCheckSocialNet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSwipe(){
		try {
			HomePage homePage = new HomePage();
			homePage.navToSettingsPage(driver);
			SettingsPage settingsPage =  new SettingsPage();
			System.out.println(driver.findElements(By.className(settingsPage.commonElement_class)).size());
			int width = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.swipe(width/2, height*3/4, width/2, height/4, 500);
			System.out.println(driver.findElements(By.className(settingsPage.commonElement_class)).size());
//			Thread.sleep(2000);
//			driver.swipe(width/2, height/4, width/2, height*3/4, 500);
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
