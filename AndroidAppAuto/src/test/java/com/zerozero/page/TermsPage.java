package com.zerozero.page;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TermsPage {
	public String text_classname = "android.widget.TextView";
	public String Button_classname = "android.widget.Button";
	public String closeBtn_id = "com.zerozero.hover:id/btnCloseTerms";
	
	public void printTextOfTermsPage(AndroidDriver<WebElement> driver){
		List<WebElement> text = driver.findElements(By.className(text_classname));
		System.out.println(text.get(0).getText());
		System.out.println(text.get(1).getText());
		
	}
	
	public void acceptTerms(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(Button_classname)).get(0).click();
	}
	
	public void closeTermsPage(AndroidDriver<WebElement> driver){
		driver.findElement(By.id(closeBtn_id)).click();
	}
}
