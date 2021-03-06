package com.zerozero.testcase;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import com.zerozero.common.MyUtil;
import com.zerozero.page.AlbumPage;
import com.zerozero.page.HomePage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAlbum {
	private AndroidDriver<WebElement> driver;
	@Before
	public void Setup(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		MyUtil.setCapabilityForNonFirstInstall(capabilities);
		
        try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Test
	public void testANavToAlbumAndSwitchResourcelist(){
		try {
			HomePage homePage = new HomePage();
			homePage.navToAlbumViewPage(driver);
			
			int widht = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
	   		driver.swipe(widht*6/7, height/2, widht*1/7, height/2, 500);
	   		Thread.sleep(2000);
	   		driver.swipe(widht*1/7, height/2, widht*6/7, height/2, 500);
	   		driver.pressKeyCode(AndroidKeyCode.BACK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBImgZoom(){
		try {
			HomePage homePage = new HomePage();
			AlbumPage albumPage = new AlbumPage();
			homePage.navToAlbumViewPage(driver);
			List<WebElement> imgList = driver.findElements(By.id(albumPage.imgThumb_Id));
			imgList.get(0).click();
//			driver.tap(2, driver.findElement(By.id("com.zerozero.hover:id/image")), 1);
//			driver.tap(2, driver.findElement(By.id("com.zerozero.hover:id/image")), 1);
//			driver.tap(2, driver.findElement(By.id("com.zerozero.hover:id/image")), 1);
//			 driver.performTouchAction((new TouchAction(driver)).tap(540,960)).waitAction().perform();
			int widht = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			driver.zoom(widht/2,height/2);
			Thread.sleep(3000);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testCOpenImgOneByOne(){
		try {
			HomePage homePage = new HomePage();
			AlbumPage albumPage = new AlbumPage();
			homePage.navToAlbumViewPage(driver);
			albumPage.openImgOneByOne(driver);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDOpenImgAndSwipeToView(){
		System.out.println("testCase: open one image and swipe to view the others");
		try {
			HomePage homePage = new HomePage();
			AlbumPage albumPage = new AlbumPage();
			homePage.navToAlbumViewPage(driver);
			int imgCount = albumPage.openOneImg(driver);
			for(int i=0; i<imgCount; i++){
				int widht = driver.manage().window().getSize().width;
		   	 	int height = driver.manage().window().getSize().height;
		   	 	driver.swipe(widht*6/7, height/2, widht*2/7, height/2, 1000);
			}
			
			for (int i=0; i<imgCount; i++){
				int widht = driver.manage().window().getSize().width;
		   	 	int height = driver.manage().window().getSize().height;
		   	 	driver.swipe(widht*2/7, height/2, widht*6/7, height/2, 1000);
			}
			albumPage.backFromBigImgView(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testESlectAndDeselct(){
		System.out.println("testCase: select and deselect the image");
		try {
			HomePage homePage = new HomePage();
			AlbumPage albumPage = new AlbumPage();
			homePage.navToAlbumViewPage(driver);
			albumPage.selectImg(driver, 3);
			assertTrue("counter of image selected is incorrect after selecting image", driver.findElement(By.id(albumPage.imgSelectionText_Id)).getText().equals("4 items selected"));
			albumPage.deselectImg(driver, 2);
			assertTrue("counter of image selected is incorrect after deselecting image ", driver.findElement(By.id(albumPage.imgSelectionText_Id)).getText().equals("2 items selected"));
			albumPage.selectAll(driver);
			albumPage.deselectAll(driver);
			assertTrue("counter of image selected is incorrect after deselecting all", driver.findElement(By.id(albumPage.imgSelectionText_Id)).getText().equals("0 items selected"));
			albumPage.cancelSelectStatus(driver);
			driver.pressKeyCode(AndroidKeyCode.BACK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFThirdpartyShareOption(){
		System.out.println("testCase: check option of share");
		try {
			HomePage homePage = new HomePage();
			AlbumPage albumPage = new AlbumPage();
			homePage.navToAlbumViewPage(driver);
			albumPage.openShareDialogInImgList(driver);
			assertTrue("sharefacebook is missing", MyUtil.isElementExist(driver, albumPage.shareFacebook_Id));
			assertTrue("shareInstagram is missing", MyUtil.isElementExist(driver, albumPage.shareInstagram_Id));
			assertTrue("sharetwitter is missing", MyUtil.isElementExist(driver, albumPage.shareTwitter_Id));
			assertTrue("sharewechat is missing", MyUtil.isElementExist(driver, albumPage.shareWechat_Id));
			assertTrue("sharewechat_timeline is missing", MyUtil.isElementExist(driver, albumPage.shareWechatTimeline_Id));
			assertTrue("shareweibo is missing", MyUtil.isElementExist(driver, albumPage.shareWeibo_Id));
			albumPage.closeShareDialog(driver);
			albumPage.cancelSelectStatus(driver);
			//check on big image mode
			albumPage.openShareDialogInBigImg(driver);
			assertTrue("sharefacebook is missing", MyUtil.isElementExist(driver, albumPage.shareFacebook_Id));
			assertTrue("shareInstagram is missing", MyUtil.isElementExist(driver, albumPage.shareInstagram_Id));
			assertTrue("sharetwitter is missing", MyUtil.isElementExist(driver, albumPage.shareTwitter_Id));
			assertTrue("sharewechat is missing", MyUtil.isElementExist(driver, albumPage.shareWechat_Id));
			assertTrue("sharewechat_timeline is missing", MyUtil.isElementExist(driver, albumPage.shareWechatTimeline_Id));
			assertTrue("shareweibo is missing", MyUtil.isElementExist(driver, albumPage.shareWeibo_Id));
			albumPage.closeShareDialog(driver);
			driver.pressKeyCode(AndroidKeyCode.BACK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//make sure more than two images are existed.
		@Test
		public void testDelAllImg(){
			System.out.println("testCase: delete all images in album");
			try {
				HomePage homePage = new HomePage();
				AlbumPage albumPage = new AlbumPage();
				homePage.navToAlbumViewPage(driver);
				albumPage.delAllImg(driver);
				assertTrue("Fail to delete all images", driver.findElement(By.id(albumPage.textEmpty_Id)).getText().equals("No Photos"));
				driver.pressKeyCode(AndroidKeyCode.BACK);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	@Test
	public void testDelAllImgOneByOne(){
		System.out.println("testCase: delete all images one by one");
		try {
			HomePage homePage = new HomePage();
			AlbumPage albumPage = new AlbumPage();
			homePage.navToAlbumViewPage(driver);
			albumPage.delAllImgOneByOne(driver);
			assertTrue("Fail to delete all images", driver.findElement(By.id(albumPage.textEmpty_Id)).getText().equals("No Photos"));
			driver.pressKeyCode(AndroidKeyCode.BACK);
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
