package com.zerozero.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	
	public String homeTitle_id = "com.zerozero.hover:id/home_title";
	public String getStarted_id = "com.zerozero.hover:id/btn_start";
	public String scenes_id = "com.zerozero.hover:id/tv_title";
	public String lockMessage_id = "com.zerozero.hover:id/text";
	public String lockMessageText = "Use “First Step”to unlock other scenes!";
	public String parentForAnimate= "com.zerozero.hover:id/rlParentForAnimate";
	public String settings_id = "com.zerozero.hover:id/iv_settings";
	String [] sceneNames = {"First Step", "Manual Control", "Group Photo", 
			"Bird’s Eye", "Running", "Cycling", "Orbit", "360 Spin"};
	
	//home页权限弹窗
//	public String allowAuthorityBtn_id = "android:id/button1";
//	public String denyAuthorityBtn_id = "android:id/button2";
	public String allowAuthorityBtn_id = "com.android.packageinstaller:id/permission_allow_button";
	public String denyAuthorityBtn_id = "com.android.packageinstaller:id/permission_deny_button";
	
	public boolean allowAuthority(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(allowAuthorityBtn_id)).click();
		driver.findElement(By.id(allowAuthorityBtn_id)).click();
		return true;
	}
	
	public void swipeTab(AndroidDriver<WebElement> driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int widht = driver.manage().window().getSize().width;
   	 	int height = driver.manage().window().getSize().height;
   		driver.swipe(widht*3/4, height* 15/16, widht/4, height*15/16, 500);
	}
	
	public void checkScenesOfLocked(AndroidDriver<WebElement> driver) throws Exception{
		swipeTab(driver);
   		List<WebElement> scenesList = driver.findElements(By.id(scenes_id));
   		for (int i=0; i<scenesList.size(); i++){
   			WebElement scene = scenesList.get(i);
   			String sceneName = scene.getText();
   			if(sceneName.equals(sceneNames[1])){
   				scene.click();
   				driver.findElement(By.id(getStarted_id)).click();
   		   		System.out.println(sceneName+ ": " + driver.findElement(By.id(lockMessage_id)).getText());
   		   		driver.findElement(By.id(parentForAnimate)).click();//make the message disappeared
   				break;
   			}
   		}
   		
   		swipeTab(driver);
   		List<WebElement> scenesList02 = driver.findElements(By.id(scenes_id));
   		System.out.println(scenesList02);
   		for(int i=0; i<scenesList02.size(); i++){
   			System.out.println(scenesList02.get(i).getText());
   		}
   		for (int i=0; i<scenesList02.size(); i++){
   			WebElement scene = scenesList02.get(i);
   			String sceneName = scene.getText();
   			if(sceneName.equals(sceneNames[2])){
   				scene.click();
   		   		driver.findElement(By.id(getStarted_id)).click();
   		   		System.out.println(sceneName + ": " + driver.findElement(By.id(lockMessage_id)).getText());
   		   		driver.findElement(By.id(parentForAnimate)).click();
   				break;
   			}
   		}
   		
   		swipeTab(driver);
   		List<WebElement> scenesList03 = driver.findElements(By.id(scenes_id));
   		for (int i=0; i<scenesList03.size(); i++){
   			WebElement scene = scenesList03.get(i);
   			String sceneName = scene.getText();
   			if(sceneName.equals(sceneNames[3])){
   				scene.click();
   		   		driver.findElement(By.id(getStarted_id)).click();
   		   		System.out.println(sceneName + ": " + driver.findElement(By.id(lockMessage_id)).getText());
   		   		driver.findElement(By.id(parentForAnimate)).click();
   				break;
   			}
   		}

   		swipeTab(driver);
   		List<WebElement> scenesList04 = driver.findElements(By.id(scenes_id));
   		for (int i=0; i<scenesList04.size(); i++){
   			WebElement scene = scenesList04.get(i);
   			String sceneName = scene.getText();
   			if(sceneName.equals(sceneNames[4])){
   				scene.click();
   		   		driver.findElement(By.id(getStarted_id)).click();
   		   		System.out.println(sceneName+ ": " + driver.findElement(By.id(lockMessage_id)).getText());
   		   		driver.findElement(By.id(parentForAnimate)).click();
   				break;
   			}
   		}

   		swipeTab(driver);
   		List<WebElement> scenesList05 = driver.findElements(By.id(scenes_id));
   		for (int i=0; i<scenesList05.size(); i++){
   			WebElement scene = scenesList05.get(i);
   			String sceneName = scene.getText();
   			if(sceneName.equals(sceneNames[5])){
   				scene.click();
   		   		driver.findElement(By.id(getStarted_id)).click();
   		   		System.out.println(sceneName + ": " + driver.findElement(By.id(lockMessage_id)).getText());
   		   		driver.findElement(By.id(parentForAnimate)).click();
   				break;
   			}
   		}

   		swipeTab(driver);
   		List<WebElement> scenesList06 = driver.findElements(By.id(scenes_id));
   		for (int i=0; i<scenesList06.size(); i++){
   			WebElement scene = scenesList06.get(i);
   			String sceneName = scene.getText();
   			if(sceneName.equals(sceneNames[6])){
   				scene.click();
   		   		driver.findElement(By.id(getStarted_id)).click();
   		   		System.out.println(sceneName + ": " + driver.findElement(By.id(lockMessage_id)).getText());
   		   		driver.findElement(By.id(parentForAnimate)).click();
   				break;
   			}
   		}

   		swipeTab(driver);
   		List<WebElement> scenesList07 = driver.findElements(By.id(scenes_id));
   		for (int i=0; i<scenesList07.size(); i++){
   			WebElement scene = scenesList07.get(i);
   			String sceneName = scene.getText();
   			if(sceneName.equals(sceneNames[7])){
   				scene.click();
   		   		driver.findElement(By.id(getStarted_id)).click();
   		   		System.out.println(sceneName + ": " + driver.findElement(By.id(lockMessage_id)).getText());
   		   		driver.findElement(By.id(parentForAnimate)).click();
   				break;
   			}
   		}
   		
	}
	
}
