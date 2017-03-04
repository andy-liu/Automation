package com.zerozero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.zerozero.common.MyUtil;

public class HomePage {
	
	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	
	public String productLink_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.product";
	public String account_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.account";
	public String signInOrSignUpLink_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.account > div > ul > li:nth-child(1)";
	public String myOrdersLink_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.account > div > ul > li:nth-child(2)";
	public String appLick_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.app";
	public String currentLocale_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.lang";
	public String firstLocaleOption_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.lang > div > ul > li:nth-child(1)";
	public String secondLocaleOption_css = "#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.lang > div > ul > li:nth-child(2)";
	
	public void changeLocaleToUS(WebElement currentLocale, WebDriver driver) throws Exception{
		MyUtil.MouseHoverByJavaScript(currentLocale, driver);
		WebElement firstLocalOption = driver.findElement(By.cssSelector(firstLocaleOption_css));
		WebElement secondLocalOption = driver.findElement(By.cssSelector(secondLocaleOption_css));
		if (firstLocalOption.getText().equals("United States")){
			firstLocalOption.click();
		}
		else {
			secondLocalOption.click();
		}
	}
	
	public void changeLocaleToGlobal(WebElement currentLocale, WebDriver driver) throws Exception{
		MyUtil.MouseHoverByJavaScript(currentLocale, driver);
		WebElement firstLocalOption = driver.findElement(By.cssSelector(firstLocaleOption_css));
		WebElement secondLocalOption = driver.findElement(By.cssSelector(secondLocaleOption_css));
		if (firstLocalOption.getText().equals("Global")){
			firstLocalOption.click();
		}
		else {
			secondLocalOption.click();
		}
	}
	
	public void changeLocaleToZh(WebElement currentLocale, WebDriver driver) throws Exception{
		MyUtil.MouseHoverByJavaScript(currentLocale, driver);
		WebElement firstLocalOption = driver.findElement(By.cssSelector(firstLocaleOption_css));
		WebElement secondLocalOption = driver.findElement(By.cssSelector(secondLocaleOption_css));
		if (firstLocalOption.getText().equals("中国大陆")){
			firstLocalOption.click();
		}
		else{
			secondLocalOption.click();
		}
	}
	
	public void navToSignInPage(WebDriver driver) throws Exception{
		MyUtil.MouseHoverByJavaScript(driver.findElement(By.cssSelector(account_css)), driver);
		driver.findElement(By.cssSelector(signInOrSignUpLink_css)).click();
	}
}
