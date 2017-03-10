package com.zerozero.page;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TermsPage {
	public String text_classname = "android.widget.TextView";
	public String Button_classname = "android.widget.Button";
	public String acceptBtn_id ="com.zerozero.hover:id/button2";
	public String closeBtn_id = "com.zerozero.hover:id/btnCloseTerms";
	
	public void printTextOfTermsPage(AndroidDriver<WebElement> driver){
		List<WebElement> text = driver.findElements(By.className(text_classname));
		System.out.println(text.get(0).getText());
		System.out.println(text.get(1).getText());
		
	}
	
	public void closeTermsPage(AndroidDriver<WebElement> driver){
		WebElement closeBtn = driver.findElement(By.id(closeBtn_id));
		closeBtn.click();
	}
	
	public void acceptTermsAndPassTutorial(AndroidDriver<WebElement> driver) throws InterruptedException{
		WebElement acceptBtn = driver.findElements(By.className(Button_classname)).get(0);
		acceptBtn.click();
		int width = driver.manage().window().getSize().width;
   	 	int height = driver.manage().window().getSize().height;
   	 	for(int i=0; i<5; i++){
   		 driver.swipe(width*6/7, height/2, width*1/7, height/2, 500);
   		 Thread.sleep(2000);
   	 	}
   	 	WebElement Enjoy_btn = driver.findElement(By.id("com.zerozero.hover:id/enjoy"));
   	 	Enjoy_btn.click();
	}
	
}
