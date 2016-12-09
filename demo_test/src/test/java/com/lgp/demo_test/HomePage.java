package com.lgp.demo_test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;

public class HomePage {
	
	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	public String Baseurl = "http://0s9fsl12p3.aws.test.gethover.com/";
	public String Orderurl = "http://0s9fsl12p3.aws.test.gethover.com/account/orders";
	public String Username = "liuguoping@zerozero.cn";
	public String Password = "565483520";
	public String Account_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.account > a";
	public String Signin_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li:nth-child(2) > div > ul > li:nth-child(1) > a";
	public String Myorders_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li:nth-child(2) > div > ul > li:nth-child(2) > a";
	public String Emailinput_css = "#login--form > form > div:nth-child(2) > input";
	public String Pwdinput_css = "#login--form > form > div:nth-child(3) > input";
	public String Signinbtn_css = "#login--form > form > button";
	public String Locale_css = "#wrapper > div.footer > div.bottom--box > div > ul > li.lang.visible__pc > a";
	
	public void naviToHomepage(WebDriver driver){
		driver.get(Baseurl);
		driver.manage().window().maximize();
	}
	
	public void changeLocaleToUS(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement localeBtn = driver.findElement(By.cssSelector(Locale_css));
		if (localeBtn.getText().equals("GLOBAL"))
			localeBtn.click();
	}
	
	public void login(WebDriver driver) throws InterruptedException{

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Account_link = driver.findElement(By.cssSelector(Account_css));
		Account_link.click();
//		Actions actions = new Actions(driver);
//		actions.moveToElement(Account_link);
		WebElement Signin_link = driver.findElement(By.cssSelector(Signin_css));
		Signin_link.click();
		WebElement EmailInput = driver.findElement(By.cssSelector(Emailinput_css));
//		System.out.println("账号输入框！");
		EmailInput.sendKeys(Username);
		WebElement PwdInput = driver.findElement(By.cssSelector(Pwdinput_css));
		PwdInput.sendKeys(Password);
		WebElement SigninBtn = driver.findElement(By.cssSelector(Signinbtn_css));
		SigninBtn.click();
//		Thread.sleep(2000);
	}
	public boolean ifLoginsuccess(WebDriver driver) throws Exception{
		WebElement accountBtn = driver.findElement(By.cssSelector(Account_css));
		accountBtn.click();
		WebElement orderBtn = driver.findElement(By.cssSelector(Myorders_css));
		orderBtn.click();
		if (driver.getCurrentUrl().equals(Orderurl))
			return true;
		else
			System.out.println(driver.getCurrentUrl());
			return false;
	}
	
		
}
