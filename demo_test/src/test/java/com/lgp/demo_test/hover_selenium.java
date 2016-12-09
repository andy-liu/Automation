package com.lgp.demo_test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class hover_selenium {
	private WebDriver driver;

	@Before
	public void setup(){
		driver = new ChromeDriver();
		System.out.println("setup!");
	}

	@Test
	public void test()  {
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		HomePage homepage = new HomePage();
		try {
			homepage.naviToHomepage(driver);
			homepage.changeLocaleToUS(driver);
			homepage.login(driver);
			boolean ifloginsuccess = homepage.ifLoginsuccess(driver);
			if (ifloginsuccess)
			System.out.println("Login success!");
		else
			System.out.println("Login failed!");
//			Assert.assertTrue("Login failed!", ifloginsuccess);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	@After
	public void teardown(){
		driver.quit();
		System.out.println("teardown!");
	}

}
