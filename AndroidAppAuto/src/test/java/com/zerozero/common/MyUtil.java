package com.zerozero.common;


import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public final class MyUtil {
	
	public MyUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setCapabilityForFirstInstall(DesiredCapabilities capabilities){
		File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "HoverCamera.apk");
        capabilities.setCapability("deviceName","a26632af");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.zerozero.hover");
        capabilities.setCapability("appActivity", ".newui.splash.SplashActivity");
      
//        capabilities.setCapability("appWaitActivity", "com.zerozero.hover.TermsAndPolicyInfoActivity");
	}
	
	public static void setCapabilityForNonFirstInstall(DesiredCapabilities capabilities){
        capabilities.setCapability("deviceName","a26632af");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.zerozero.hover");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appActivity", ".newui.splash.SplashActivity");
        capabilities.setCapability("appWaitActivity", ".newui.home.HomeActivity");
//        capabilities.setCapability("appActivity", ".newui.splash.SplashActivity");
	}
	
	public static boolean isElementExist(AndroidDriver<WebElement> driver, String id){
		try {
			driver.findElement(By.id(id));
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public static boolean isElementExist(AndroidDriver<WebElement> driver, String className, String byClass){
		try {
			driver.findElement(By.className(className));
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public static void connectToCameraWifiIfNot(AndroidDriver<WebElement> driver) throws Exception{
		WebElement connectStatus = driver.findElements(By.className("android.widget.TextView")).get(2);
		if(connectStatus.getText().equals("Disconnected from Hover Camera.")){
			driver.findElement(By.id("com.zerozero.hover:id/home_wifi")).click();
//			int width = driver.manage().window().getSize().width;
//	   	 	int height = driver.manage().window().getSize().height;
//	   	 	System.out.println(height);
//			driver.swipe(width/2, height*3/4, width/2, height/4, 50);
			List<WebElement> wifiList = driver.findElements(By.id("android:id/title"));
			for (WebElement wifi: wifiList){
				if (wifi.getText().equals("HoverCamera_499691")){
					System.out.println("HoverCamera wifi is found!");
					wifi.click();
					break;
				}
			}
			driver.navigate().back();
			for(int i=0; i<4; i++){
				if(connectStatus.getText().equals("You are connected.")){
					System.out.println("Success to connect to HoverCamera!");
					break;
				}
				Thread.sleep(2000);
			}
		}	
	}
}

