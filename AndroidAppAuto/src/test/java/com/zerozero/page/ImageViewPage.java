package com.zerozero.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zerozero.common.MyUtil;

import io.appium.java_client.android.AndroidDriver;

public class ImageViewPage {
	/*
	 * photo mode
	 */
	public String videoMode_Id = "com.zerozero.hover:id/camera_more";
	public String cameraShut_Id = "com.zerozero.hover:id/btn_camera_shutter";
	public String imgPreview_Id = "com.zerozero.hover:id/img_pre_layout_bg";
	public String imgPreviewLoading_Id = "com.zerozero.hover:id/take_picture_preview_loading";
	public String switchToVideoBtn_Id = "com.zerozero.hover:id/btn_camera_to_video";
	public String cameraTimer_Id ="com.zerozero.hover:id/btn_camera_timer";
	public String captureTimer_Id = "com.zerozero.hover:id/image_capture_timer";
	public String cameraFlashBtn_Id = "com.zerozero.hover:id/btn_camera_flash";
	public String cameraFlipBtn_Id = "com.zerozero.hover:id/btn_camera_flip";
	public String flyControlBtn_Id = "com.zerozero.hover:id/btn_fly_control";
	public String flyLandBtn_Id = "com.zerozero.hover:id/btn_fly_land";
	public String backFromeImgPreBtn_Id = "com.zerozero.hover:id/btn_album_back";
	public String alertContent_Id = "com.zerozero.hover:id/alert_content";
	public String alertContentText = "This feature is only available while Hover Camera is flying";
	public String alertOkBtn_Id = "com.zerozero.hover:id/alert_ok";
	
	
	public void changeToPhotoMode(AndroidDriver<WebElement> driver) throws Exception{
		if(!MyUtil.isElementExist(driver, cameraTimer_Id)){
			driver.findElement(By.id(cameraMode_Id)).click();
			Thread.sleep(2000);
		}
		else {
			driver.findElement(By.id(videoMode_Id)).click();
			Thread.sleep(2000);
			driver.findElement(By.id(cameraMode_Id)).click();
			Thread.sleep(2000);
		}
	}
	
	public void changeToVideoMode(AndroidDriver<WebElement> driver) throws Exception{
		if(MyUtil.isElementExist(driver, cameraTimer_Id)){
			driver.findElement(By.id(videoMode_Id)).click();
			Thread.sleep(2000);
		}
			else {
				driver.findElement(By.id(cameraMode_Id)).click();
				Thread.sleep(2000);
				driver.findElement(By.id(videoMode_Id)).click();
				Thread.sleep(2000);
			}
	}
	
	//默认设置拍照
	public void takePhoto(AndroidDriver<WebElement> driver) throws Exception{
		//make sure it is photo mode
		changeToPhotoMode(driver);
		WebElement cameraShot = driver.findElement(By.id(cameraShut_Id));
		cameraShot.click();
//		Thread.sleep(8000);
	}
	
	//五秒倒计时拍照
	public void takePhotoWithTimer(AndroidDriver<WebElement> driver) throws Exception{
		//make sure it is photo mode
		changeToPhotoMode(driver);
		driver.findElement(By.id(cameraTimer_Id)).click();
		driver.findElement(By.id(cameraShut_Id)).click();
	}
	
	//闪光拍照
	public void takePhotoWithFlash(AndroidDriver<WebElement> driver) throws Exception{
		changeToPhotoMode(driver);
		driver.findElement(By.id(cameraFlashBtn_Id)).click();
		driver.findElement(By.id(cameraShut_Id)).click();
	}
	
	public void previewPhotoAndBack(AndroidDriver<WebElement> driver) throws Exception{
		Thread.sleep(10000);
		WebElement imgPreview = driver.findElement(By.id(imgPreview_Id));
		imgPreview.click();

		WebElement backFromeImgPreBtn = driver.findElement(By.id(backFromeImgPreBtn_Id));
		backFromeImgPreBtn.click();
		driver.navigate().back();
	}
	
	public void flyLand(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(flyLandBtn_Id)).click();
	}
	
	/*
	 * video mode
	 */
	public String cameraMode_Id = "com.zerozero.hover:id/camera_more";
	public String videoShot_Id = "com.zerozero.hover:id/btn_camera_shutter";
	public String outerArrowBtn_Id = "com.zerozero.hover:id/btn_video_outer_arrow";
	public String innerArrowBtn_Id = "com.zerozero.hover:id/btn_video_inner_arrow";
	public String trackFaceBtn_Id = "com.zerozero.hover:id/btn_video_track_face";
	public String trackBodyBtn_Id = "com.zerozero.hover:id/btn_video_track_body";
	public String orbitBtn_Id = "com.zerozero.hover:id/btn_video_orbit";
	public String yaw360Btn_Id = "com.zerozero.hover:id/btn_video_yaw360";

	public void extendFeatureBar(AndroidDriver<WebElement> driver) throws Exception{
		if(MyUtil.isElementExist(driver, outerArrowBtn_Id))
			driver.findElement(By.id(outerArrowBtn_Id)).click();
	}
	
	public void collapseFeatureBar(AndroidDriver<WebElement> driver) throws Exception{
		if(MyUtil.isElementExist(driver, innerArrowBtn_Id))
			driver.findElement(By.id(outerArrowBtn_Id)).click();
	}
	
	public void videoShot(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(videoShot_Id)).click();
	}
	
	public void trackFace(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(trackFaceBtn_Id)).click();
	}
	
	public void trackBody(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(trackBodyBtn_Id)).click();
	}
	
	public void orbit(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(orbitBtn_Id)).click();
	}
	
	public void yaw360(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(yaw360Btn_Id)).click();
	}
			
}
