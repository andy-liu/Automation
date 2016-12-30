package com.zerozero.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zerozero.page.TermsPage;

import io.appium.java_client.android.AndroidDriver;

public class TutorialPage {
	public String skipBtn_Id = "com.zerozero.hover:id/tutorial_skip_button";
	
	public void skipTutorial(AndroidDriver<WebElement> driver) throws Exception{
		TermsPage termsPage = new TermsPage();
		WebElement acceptBtn = driver.findElement(By.id(termsPage.acceptBtn_id));
		acceptBtn.click();
		int widht = driver.manage().window().getSize().width;
   	 	int height = driver.manage().window().getSize().height;
   		driver.swipe(widht*6/7, height/2, widht*1/7, height/2, 500);
   		Thread.sleep(2000);
		WebElement skipBtn = driver.findElement(By.id(skipBtn_Id));
		skipBtn.click();
	}

}
