package com.zerozero.AndroidAppAutoTestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.zerozero.common.MyUtil;

import io.appium.java_client.android.AndroidDriver;

public class TrySomething {
	
	private static AndroidDriver<WebElement> driver;
	@BeforeClass
	public static void SetUp(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		MyUtil.setCapabilityForNonFirstInstall(capabilities);
		
        try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//			driver.closeApp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Before
	public void setUp(){
		driver.launchApp();
	}
	
	@Test
	public void test() {
		try {
			System.out.println("it is test");
			Thread.sleep(2000);
			MyUtil.connectToCamera(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
//	@Test
//	public void test02() {
//		try {
//			driver.findElement(By.id("com.zerozero.hover:id/home_wifi")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.id("android:id/switchWidget")).click();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//	}
	@After
	public void tearDown(){
		driver.closeApp();

	}
	
	@AfterClass
	public static void TearDown(){
		driver.quit();//end the session
	}

}
