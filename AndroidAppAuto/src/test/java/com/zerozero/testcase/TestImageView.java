package com.zerozero.testcase;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.ui.context.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import com.zerozero.common.MyUtil;
import com.zerozero.page.HomePage;
import com.zerozero.page.ImageViewPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestImageView {
	private AndroidDriver<WebElement> driver;
	
	@Before
	public void setUp(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		MyUtil.setCapabilityForNonFirstInstall(capabilities);
		
        try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Test
	public void testSwitchModeBetweenPhotoAndVideo() {
		System.out.println("testCase: Switch Mode Between Photo And Video");
		HomePage homePage = new HomePage();
		List<WebElement> scenesList = driver.findElements(By.id(homePage.scenes_id));
	   	for (int i=0; i<scenesList.size(); i++){
	   			WebElement scene = scenesList.get(i);
	   			String sceneName = scene.getText();
	   			if(sceneName.equals("Manual Control")){
	   				scene.click();
	   				break;
	   			}
	   		}
	   		driver.findElement(By.id(homePage.getStarted_id)).click();
	   		try {
	   			WebElement tutorial_GoBtn = driver.findElement(By.id("com.zerozero.hover:id/tutorial_start_btn"));
	   			tutorial_GoBtn.click();
	   		} catch (Exception e) {
				// TODO: handle exception
	   			e.printStackTrace();
			}
	   		
	   		driver.findElement(By.id("com.zerozero.hover:id/caution_view_close")).click();
	   		try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   		for(int i=0; i<=10; i++){
	   			driver.findElement(By.id("com.zerozero.hover:id/btn_camera_switch_video")).click();
	   			try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	   			System.out.println("第"+i+"次切换");
	   		}
	   		driver.pressKeyCode(AndroidKeyCode.BACK);		
	}
	
	@Test
	public void testTakePhotoInGroupPhoto(){
		System.out.println("testCase: Take photos in group photo");
		HomePage homePage = new HomePage();
		homePage.swipeTab(driver);
		List<WebElement> scenesList = driver.findElements(By.id(homePage.scenes_id));
	   	for (int i=0; i<scenesList.size(); i++){
	   			WebElement scene = scenesList.get(i);
	   			String sceneName = scene.getText();
	   			if(sceneName.equals("Group Photo")){
	   				scene.click();
	   				break;
	   			}
	   		}
	   	driver.findElement(By.id(homePage.getStarted_id)).click();
	   	try {
	   		WebElement tutorial_GoBtn = driver.findElement(By.id("com.zerozero.hover:id/tutorial_start_btn"));
	   		tutorial_GoBtn.click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	   	
	   	driver.findElement(By.id("com.zerozero.hover:id/caution_view_close")).click();
	   	driver.findElement(By.id("com.zerozero.hover:id/btn_camera_shutter")).click();
	   	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	driver.pressKeyCode(AndroidKeyCode.BACK);
	   	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	driver.pressKeyCode(AndroidKeyCode.BACK);
	}
	
	@Test
	public void testTakePhotoWithTimer(){
		System.out.println("testCase: navigate to imageView, take photo with timer and preview photo!");

	}
	
	@Test
	public void testTakePhotoWithFlash(){
		System.out.println("testCase: navigate to imageView, take photo with flash and preview photo!");
		
	}
	
	@Test
	public void testChangeModeOfImgView(){
		System.out.println("testCase: change mode between video and photo");
		
	}
	
	//fly land is not available when not flying both photo mode and video mode
	@Test
	public void testFlyLandWithoutFly() {
		System.out.println("testCase: Fly Land is not available when not flying");
		
}
	
	@Test
	public void testVideoShotWithoutFly(){
		System.out.println("testCase: video shot is not available when not flying");
		
	}
	
	@Test
	public void testTrackWithoutFly(){
		System.out.println("testCase: track and yaw360 are not available when not flying");
		
	}
	
	@Test
	public void testWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			HomePage homePage = new HomePage();
			homePage.navToImageViewPage(driver);
			ImageViewPage imageViewPage = new ImageViewPage();
			driver.findElement(By.id(imageViewPage.cameraShut_Id)).click();
			driver.findElement(By.id(imageViewPage.imgPreviewLoading_Id));
			System.out.println("找到了！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
}
