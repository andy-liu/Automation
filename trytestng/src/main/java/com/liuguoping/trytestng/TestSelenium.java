package com.liuguoping.trytestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium {
  @Test(invocationCount = 10, threadPoolSize = 3)
  public void fuc() {
	  System.setProperty("webdriver.chrome.driver", "C://Users//liuguoping//Downloads//chromedriver_win32//chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.baidu.com/");
	  System.out.println(Thread.currentThread().getId());
	  System.out.println(driver.getTitle());
	  driver.quit();
  }
}
