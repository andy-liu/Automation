package com.zerozero.testcase;

import static org.junit.Assert.*;

import java.io.File;
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
import com.zerozero.page.AlbumPage;
import com.zerozero.page.HomePage;
import com.zerozero.page.ImageViewPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class demo {
	private static AndroidDriver<WebElement> driver;
	File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "apps");
    File app = new File(appDir, "HoverCamera.apk");
    
	@BeforeClass
	public static void testBeforeClass(){
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
	
	@Before
	public void testBefore(){
		driver.launchApp();
	}
	
	@AfterClass
	public static void testAfterClass(){
		driver.quit();
	}
	
	@After
	public void testAfter(){
		driver.closeApp();
	}
	
	@Test
	public void testInstallAndUninstall(){
		System.out.println("***********Install and uninstall app***************");
		driver.removeApp("com.zerozero.hover");
		if (!driver.isAppInstalled("com.zerozero.hover")){
			System.out.println("Success to uninstall");
			driver.installApp(app.getAbsolutePath());
			if (driver.isAppInstalled("com.zerozero.hover"))
				System.out.println("Success to install");
			else
				System.out.println("Fail to install");
		}
		else
			System.out.println("Fail to uninstall");
	}
	
	@Test
	public void testTakePhoto() {
		System.out.println("***********Take photo***************");
		try {
			HomePage homePage = new HomePage();
//			MyUtil.connectToCameraWifiIfNot(driver);
			homePage.navToImageViewPage(driver);
			ImageViewPage imageViewPage = new ImageViewPage();
			for (int i=0; i<5; i++){
				imageViewPage.takePhoto(driver);
			}
			driver.pressKeyCode(AndroidKeyCode.BACK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Test
	public void testOpenPhotoFromAlbum(){
		System.out.println("***********Open photo from album***************");
		try {
			HomePage homePage = new HomePage();
			AlbumPage albumPage = new AlbumPage();
			homePage.navToAlbumViewPage(driver);
			int imgCount = albumPage.openOneImg(driver);
			int widht = driver.manage().window().getSize().width;
	   	 	int height = driver.manage().window().getSize().height;
			for(int i=0; i<imgCount; i++){
		   	 	driver.swipe(widht*6/7, height/2, widht*2/7, height/2, 1000);
			}
			
			for (int i=0; i<imgCount; i++){
		   	 	driver.swipe(widht*2/7, height/2, widht*6/7, height/2, 1000);
			}
			albumPage.backFromBigImgView(driver);
			driver.pressKeyCode(AndroidKeyCode.BACK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeletePhoto(){
		System.out.println("***********Delete photo***************");
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
}
