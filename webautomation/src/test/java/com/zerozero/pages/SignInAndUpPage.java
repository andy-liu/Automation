package com.zerozero.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInAndUpPage {
	public SignInAndUpPage() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * sign in
	 */
	public String inputBox_classname = "acount--input ";
	public String signInBtn_css = "#login--form > form > button";
	
	/*
	 * sign up
	 */
	
	public void SignIn(String email, String pwd, WebDriver driver) throws Exception{
		List<WebElement> InputList = driver.findElements(By.className(inputBox_classname));
		InputList.get(0).sendKeys(email);
		InputList.get(1).sendKeys(pwd);
		driver.findElement(By.cssSelector(signInBtn_css)).click();
	}
}
