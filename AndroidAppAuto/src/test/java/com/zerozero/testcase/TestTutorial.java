package com.zerozero.testcase;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import com.zerozero.common.MyUtil;
import com.zerozero.page.HomePage;
import com.zerozero.page.TermsPage;
import com.zerozero.page.TutorialPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTutorial {
	private  AndroidDriver<WebElement> driver;

	@Before
	public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
		MyUtil.setCapabilityForFirstInstall(capabilities);
        try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCloseTermspage(){
		System.out.println("testCase: close terms page!");
//		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        try {
        	TermsPage termsPage = new TermsPage();
        	termsPage.closeTermsPage(driver);
        	driver.quit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testSkipTutorial(){
		System.out.println("testCase: skip tutorial!");
		try {
			TutorialPage tutorialPage = new TutorialPage();
			HomePage homePage = new HomePage();
			tutorialPage.skipTutorial(driver);
			boolean resultOfSkipTutorial = MyUtil.isElementExist(driver, homePage.albumViewBtn_Id);
			assertTrue("Fail to skip tutorial", resultOfSkipTutorial);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPassTutorial() {
        System.out.println("testCase: accept terms and pass the tutorial!");
		try {
	        TermsPage termsPage = new TermsPage();
			HomePage homePage = new HomePage();
			termsPage.acceptTermsAndPassTutorial(driver);
			boolean resultOfPassTutorial = MyUtil.isElementExist(driver, homePage.albumViewBtn_Id);
			assertTrue("Fail to pass tutorial", resultOfPassTutorial);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void teardown(){
		driver.quit();
	}

}
