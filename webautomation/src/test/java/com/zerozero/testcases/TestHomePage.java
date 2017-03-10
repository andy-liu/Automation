package com.zerozero.testcases;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.zerozero.common.Data;
import com.zerozero.common.MyUtil;
import com.zerozero.pages.HomePage;
import com.zerozero.pages.SignInAndUpPage;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class TestHomePage {
	private static WebDriver driver;

	@BeforeClass
	public static void setup(){
		System.setProperty("webdriver.chrome.driver", "C://Users//liuguoping//Downloads//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(Data.baseURL_Test);
		driver.manage().window().maximize();
	}

	@Test
	public void testChangeLocaleToUS()  {
		System.out.println("testCase: Change loale to US");
		try {
			HomePage homepage = new HomePage();
			WebElement currentLocal = driver.findElement(By.cssSelector(homepage.currentLocale_css));
			String region = currentLocal.getText();
			if (region.equals("United States")){
				homepage.changeLocaleToGlobal(currentLocal, driver);
			}
			homepage.changeLocaleToUS(currentLocal, driver);
			assertTrue("Fail to change locale to US!", driver.findElement(By.cssSelector(homepage.currentLocale_css)).getText().equals("United States"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	
	@Test
	public void testChangeLocaleToGlobal()  {
		System.out.println("testCase: Change loale to Global");
		try {
			HomePage homepage = new HomePage();
			WebElement currentLocal = driver.findElement(By.cssSelector(homepage.currentLocale_css));
			String region = currentLocal.getText();
			if (region.equals("Global")){
				homepage.changeLocaleToUS(currentLocal, driver);
			}
			homepage.changeLocaleToGlobal(currentLocal, driver);
			assertTrue("Fail to change locale to Global!", driver.findElement(By.cssSelector(homepage.currentLocale_css)).getText().equals("Global"));
			System.out.println("Success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	
	@Test
	public void testChangeLocaleToZh()  {
		System.out.println("testCase: Change loale to Zh");
		try {
			HomePage homepage = new HomePage();
			WebElement currentLocal = driver.findElement(By.cssSelector(homepage.currentLocale_css));
			String region = currentLocal.getText();
			if (region.equals("中国大陆")){
				homepage.changeLocaleToUS(currentLocal, driver);
			}
			homepage.changeLocaleToZh(currentLocal, driver);
			assertTrue("Fail to change locale to Zh!", driver.findElement(By.cssSelector(homepage.currentLocale_css)).getText().equals("中国大陆"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
	@Test
	public void testSignInAndOut(){
		System.out.println("testCase: Sign in and sign out");
		try {
			HomePage homePage = new HomePage();
			SignInAndUpPage signInAndUp = new SignInAndUpPage();
			homePage.navToSignInPage(driver);
			signInAndUp.SignIn(Data.userName, Data.passWord, driver);
			WebElement accountLink = driver.findElement(By.cssSelector(homePage.account_css));
			MyUtil.MouseHoverByJavaScript(accountLink, driver);
			WebElement loginStatus = driver.findElement(By.cssSelector("#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.account > div > ul > li:nth-child(1)"));
			assertTrue("Login failed", loginStatus.getText().equals("Logout") || loginStatus.getText().equals("退出"));
			System.out.println("success!----login");
			//logout
			loginStatus.click();
			MyUtil.OpenNewWindow(Data.baseURL_Test, driver);
			accountLink = driver.findElement(By.cssSelector(homePage.account_css));
			MyUtil.MouseHoverByJavaScript(accountLink, driver);
			loginStatus = driver.findElement(By.cssSelector("#wrapper > div.header > div.pc-header.clear__float.bg--write > ul > li.account > div > ul > li:nth-child(1)"));
			assertTrue("Logout failed", loginStatus.getText().equals("Sign In & Sign Up") || loginStatus.getText().equals("登录｜注册"));
			System.out.println("success!----logout");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	@Test
//	public void tryNoCatch() throws InterruptedException{
//		System.out.println("testCase: Do not catch exception");
//		driver.findElement(By.cssSelector("test")).click();
//		MyUtil.OpenNewWindow(Data.baseURL_Test, driver);
//		Thread.sleep(5000);
//	}
	
	@AfterClass
	public static void teardown(){
		driver.quit();
	}
}
