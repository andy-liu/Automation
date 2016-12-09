package com.zerozero.common;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MyUtil {
	
	public MyUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setCapabilityForFirstInstall(DesiredCapabilities capabilities){
		File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "HoverCamera.apk");
        capabilities.setCapability("deviceName","7b72de8b");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.zerozero.hover");
//        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("appActivity", ".HomeActivity");
//        capabilities.setCapability("appWaitActivity", "/.permission.ui.GrantPermissionsActivity");
        capabilities.setCapability("appWaitActivity", "com.zerozero.hover.TermsActivity");
	}
	
	public static void setCapabilityForNonFirstInstall(DesiredCapabilities capabilities){
        capabilities.setCapability("deviceName","7b72de8b");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("appPackage", "com.zerozero.hover");
//        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("appActivity", ".HomeActivity");
	}
	
	public static  boolean isElementExist(AndroidDriver<WebElement> driver, String Id){
		try {
			driver.findElement(By.id(Id));
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public static void connectToCamera(AndroidDriver<WebElement> driver) throws Exception{
		if(driver.findElements(By.className("android.widget.TextView")).get(2).getText().equals("Disconnected from Hover Camera.")){
			driver.findElement(By.id("com.zerozero.hover:id/home_wifi")).click();
			List<WebElement> wifiList = driver.findElements(By.className("android.widget.LinearLayout"));
			System.out.println(wifiList);
			for (int i=0; i<wifiList.size(); i++){
//				if (wifiList.get(i).getText().equals("PleaseLetMeAlone")){
//					System.out.println("111111111111111111111");
//					wifiList.get(i).click();
//					System.out.println("2222222222222222222");
//					break;
				System.out.println(wifiList.get(i).getText());
				}
//			driver.findElement(By.linkText("PleaseLetMeAlone")).click();
//		else {
//			System.out.println("it is connected!");
//		}
//		System.out.println(driver.findElements(By.className("android.widget.TextView")).get(2).getText());
		}
	}
}
