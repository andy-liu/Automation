package com.zerozero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
	public CheckOutPage() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * checkout as guest
	 */
	//contact information
	public String emailAddressInput_css = "#contactinfoFom > div > div.gh-input-group.pure-u-1-2.email__input > div.gh-input-group__input";
	public String emailAddressSave_css = "#contactinfoFom > div > div.gh-input-group.pure-u-1-2.email__button > button";
	
	//ship address
	public String nameInput_css = "#addressFom > div:nth-child(1) > div:nth-child(1) > div.gh-input-group__input";
	public String address_css = "#addressFom > div:nth-child(2) > div > div.gh-input-group__input";
	public String addressOptional_css = "#addressFom > div:nth-child(3) > div > div.gh-input-group__input";
	public String stateSelect_css = "#addressFom > div:nth-child(4) > div:nth-child(2) > div.gh-input-group__select > select";
	public String state_css = "#addressFom > div:nth-child(4) > div:nth-child(2) > div.gh-input-group__select > select > option:nth-child(12)";
	public String cityInput_css = "#addressFom > div:nth-child(4) > div:nth-child(3) > div.gh-input-group__input";
	public String zipInput_css = "#addressFom > div:nth-child(5) > div:nth-child(1)";
	public String phoneNumberInput_css = "#addressFom > div:nth-child(5) > div:nth-child(2)";
	public String shipInformationSave_css = "#addressFom > div:nth-child(5) > div.gh-input-group.pure-u-1-3.address__button";
	//pay option
	public String strip_css= "#payInfo > div.content > div.content__edit > div > form > div.pay__way--block.clear__float.pay--selected > label > i";
	public String amazon_css = "#payInfo > div.content > div.content__edit > div > form > div:nth-child(2) > label > i";
	public String paypal_css = "#payInfo > div.content > div.content__edit > div > form > div:nth-child(3) > label > i";
	public String placeOrder_css = "#productsInfo > div.content > div > div > div > div.payment__total.clear__float > button";
	//pay page
	public String stripAccountInput_css = "#\34 4eddb20-03cc-11e7-bb75-375baf39a502";
	public String dateInput_css = "#\34 4eec580-03cc-11e7-bb75-375baf39a502";
	public String cvcInput_css = "#\34 4eeec90-03cc-11e7-bb75-375baf39a502";
	public String submit_css = "#container > section > span:nth-child(3) > div > div > main > form > nav > div > div > div > button";
	public String zipInputOfPay_css = "#\32 f4f88d0-03cd-11e7-b316-f76ab1571bb0";
	public String resultOfPay_css = "#payResult > h1";
	
	public void inputEmailAddress(WebDriver driver, String email) throws Exception{
		WebElement emailInput = driver.findElement(By.cssSelector(emailAddressInput_css));
		emailInput.sendKeys(email);
		driver.findElement(By.cssSelector(emailAddressSave_css)).click();
	}
	
	public void inputShipInformation(WebDriver driver, String name, String address, String addressOptional, String city, String zip, String phoneNumber) throws Exception{
		driver.findElement(By.cssSelector(nameInput_css)).sendKeys(name);
		driver.findElement(By.cssSelector(address)).sendKeys(address);
		driver.findElement(By.cssSelector(addressOptional)).sendKeys(addressOptional);
		driver.findElement(By.cssSelector(stateSelect_css)).click();
		driver.findElement(By.cssSelector(state_css)).click();
		driver.findElement(By.cssSelector(zipInput_css)).sendKeys(zip);
		driver.findElement(By.cssSelector(phoneNumberInput_css)).sendKeys(phoneNumber);
		driver.findElement(By.cssSelector(shipInformationSave_css)).click();
	}
	
	public void selectOptionOfPay(WebDriver driver, String PayOfOption) throws Exception{
		if (PayOfOption.equals("strip"))
			driver.findElement(By.cssSelector(strip_css)).click();
		else if (PayOfOption.equals("amazon"))
			driver.findElement(By.cssSelector(amazon_css)).click();
		else
			driver.findElement(By.cssSelector(paypal_css)).click();
	}
	
	public void placeOrder(WebDriver driver) throws Exception{
		driver.findElement(By.cssSelector(placeOrder_css)).click();
	}
}
