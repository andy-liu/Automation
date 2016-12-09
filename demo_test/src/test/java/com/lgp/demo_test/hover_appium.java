package com.lgp.demo_test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.List;

import java.io.File;
import java.net.URL;

public class hover_appium {
	private AndroidDriver<WebElement> driver;

	@Before
	public void setup() throws Exception{
		System.out.println("setup!");
		File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "app-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","7b72de8b");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.zerozero.hover");
        capabilities.setCapability("appActivity", "com.zerozero.hover.HomeActivity");
//        capabilities.setCapability("appActivity", "com.zerozero.hover.TermsActivity");
        capabilities.setCapability("appWaitActivity", "com.zerozero.hover.TermsActivity");
        
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("setup end!");
	}
	
	@Test
	public void testAppium() {
        System.out.println("testCase!");
        try {
        	WebElement Accept_btn= driver.findElementById("com.zerozero.hover:id/button2");
        	Accept_btn.click();
        	 System.out.println("Click accept button!");
        	 int widht = driver.manage().window().getSize().width;
        	 int height = driver.manage().window().getSize().height;
        	 for(int i=0; i<6; i++){
        		 driver.swipe(widht*6/7, height/2, widht*1/7, height/2, 500);
        		 Thread.sleep(2000);
        	 }
        	 WebElement Enjoy_btn = driver.findElement(By.id("com.zerozero.hover:id/enjoy"));
        	 Enjoy_btn.click();
        	 
			
		} catch (Exception e) {
			System.out.println(e);
		}
        
	}
	
	@After
	public void teardown(){
		driver.quit();
		System.out.println("teardown!");
	}

}
