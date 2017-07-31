package com.zerozero.testcase;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.*;

import com.zerozero.common.MyUtil;
import com.zerozero.page.HomePage;
import com.zerozero.page.TermsPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestInstallAndUninstall {
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
	public void testInstallForTheFirstTime(){
		System.out.println("testCase: Install And Uninstall");
        try {
        	TermsPage termsPage = new TermsPage();
        	HomePage homePage =  new HomePage();
        	termsPage.closeTermsPage(driver);
        	driver.closeApp();
        	driver.launchApp();
        	termsPage.acceptTerms(driver);
        	homePage.allowAuthority(driver);
        	assertTrue("Fail to nav to homePage after accept terms", driver.currentActivity().equals(".newui.home.HomeActivity"));
//        	driver.removeApp("com.zerozero.hover");
//        	if (!driver.isAppInstalled("com.zerozero.hover"))
//        		System.out.println("Uninstalled successfully");
        } catch (Exception e) {
			System.out.println(e);
		}
	}

	@After
	public void tearDown(){
		driver.quit();
	}
}
