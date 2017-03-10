package com.zerozero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	public ProductPage() {
		// TODO Auto-generated constructor stub
	}
	
	//product page
	public String productItemCamera_css= "#productList > div.items__wrapper > div > div.pure-u-md-1-3.pure-u-1-2.item__main > a";
	public String productItemBattery_css = "#productList > div.items__wrapper > div > div:nth-child(2) > a";
		
	//product detail page
	public String buynow_css = "#product > div.product__wrapper > div.product__main > div.product__detail > div.product__detail__btns--pc.visible__pc > a.float--right.btn.btn-info.btn-sm";
	public String addtocart_css = "#product > div.product__wrapper > div.product__main > div.product__detail > div.product__detail__btns--pc.visible__pc > a.btn.btn-primary.btn-sm";
	
	public void navToCameraDetailPage(WebDriver driver) throws Exception{
		driver.findElement(By.cssSelector(productItemCamera_css)).click();
		Thread.sleep(5000);
	}
	
	public void buyNow(WebDriver driver) throws Exception{
		driver.findElement(By.cssSelector(buynow_css)).click();
		Thread.sleep(5000);
	}
}
