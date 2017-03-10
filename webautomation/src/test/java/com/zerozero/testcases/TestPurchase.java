package com.zerozero.testcases;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zerozero.common.Data;
import com.zerozero.pages.CheckOutPage;
import com.zerozero.pages.HomePage;
import com.zerozero.pages.ProductPage;

public class TestPurchase {
	private static WebDriver driver;
	@BeforeClass
	public static void setup(){
		System.setProperty("webdriver.chrome.driver", "C://Users//liuguoping//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(Data.baseURL_Test);
		driver.manage().window().maximize();
	}
	
	/*
	 * as guest
	 */
	@Test
	public void testBuyNow(){
		System.out.println("testCase: ");
		try {
			HomePage homePage = new HomePage();
			ProductPage productPage = new ProductPage();
			CheckOutPage checkOutPage = new CheckOutPage();
			WebElement currentLocal = driver.findElement(By.cssSelector(homePage.currentLocale_css));
			homePage.changeLocaleToUS(currentLocal, driver);
			homePage.navToProductPage(driver);
			productPage.navToCameraDetailPage(driver);
			productPage.buyNow(driver);
			checkOutPage.inputEmailAddress(driver, "liuguoping@zerozero.cn");
			checkOutPage.inputShipInformation(driver, "andy", "test", "test02", "Atlanta", "30301", "1234567890");
			checkOutPage.selectOptionOfPay(driver, "strip");
			checkOutPage.placeOrder(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		
	@AfterClass
	public static void teardown(){
		driver.quit();
	}
}
