package com.zerozero.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	
	public String homeTitle_Id = "com.zerozero.hover:id/home_title";
	public String imageViewBtn_Id = "com.zerozero.hover:id/take_picture_view";
	public String albumViewBtn_Id = "com.zerozero.hover:id/album_view";
	public String wifiBtn_Id = "com.zerozero.hover:id/home_wifi";
	public String tutorialBtn_Id = "com.zerozero.hover:id/home_tutorial";
	public String settingsBtn_Id = "com.zerozero.hover:id/home_setting";
	public String instagramBtn_Id = "com.zerozero.hover:id/home_instagram";
	
	public String connectStatus_class= "android.widget.TextView";
	
	public void navToImageViewPage(AndroidDriver<WebElement> driver) throws Exception{
		WebElement picViewBtn = driver.findElement(By.id(imageViewBtn_Id));
		picViewBtn.click();
		Thread.sleep(5000);
	}
	
	public void navToAlbumViewPage(AndroidDriver<WebElement> driver) throws Exception{
		WebElement albumViewBtn = driver.findElement(By.id(albumViewBtn_Id));
		albumViewBtn.click();

	}
	
	public void navToWifiPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(wifiBtn_Id)).click();
	}
	
	public void navToTutorialPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(tutorialBtn_Id)).click();
	}

	public void navToSettingsPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(settingsBtn_Id)).click();
	}
	
	public void navToInstagram(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(instagramBtn_Id)).click();
	}
}
