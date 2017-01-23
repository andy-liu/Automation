package com.zerozero.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class SettingsPage {

	public String backBtn_class = "android.widget.ImageButton";
	public String firmWare_class = "android.widget.LinearLayout";
	public String commonElement_class = "android.widget.TextView";
	public String faceBookLink_id = "com.zerozero.hover:id/btn_setting_social_facebook";
	public String twitterLink_id = "com.zerozero.hover:id/btn_setting_social_twitter";
	public String instagramLink_id = "com.zerozero.hover:id/btn_setting_social_instagrm";
	public String wechatLink_id = "com.zerozero.hover:id/btn_setting_social_wechat";
	public String weiboLink_id = "com.zerozero.hover:id/btn_setting_social_weibo";
	
	//about page
	public String termsLink_id = "com.zerozero.hover:id/setting_about_conditions";
	public String termsLinkText = "https://gethover.com/terms";
	
	//memory management page
	public String formatMemoryBtn_id = "com.zerozero.hover:id/setting_memory_format_memory";
	public String imageOfNotDownload_id = "com.zerozero.hover:id/shadow_bg";
	public String imageOfDownloaded_id = "com.zerozero.hover:id/image_thumb";
	public String formatAlertConfirm_id = "com.zerozero.hover:id/hint_confirm";
	public String formatAlertCancel_id = "com.zerozero.hover:id/hint_cancel";
	public String emptyStatus_id = "com.zerozero.hover:id/tvTextEmpty";
	public String deleteBtn_id = "com.zerozero.hover:id/btn_album_delete";
	public String deleteAlertCancel_id = "com.zerozero.hover:id/hint_cancel";
	public String deleteAlertConfirm_id = "com.zerozero.hover:id/hint_confirm";
	
	//beast mode page
	public String beastMode_id = "com.zerozero.hover:id/beast_mode_switch";
	
	//Record Video
	public String resolutionOption_id = "android:id/text1";
	public String autoVideoRecord_id = "com.zerozero.hover:id/video_setting_switch";
	
	//Water mark page
	public String waterMarkPhoto_id = "com.zerozero.hover:id/setting_switch_watermark_photo";
	public String waterMarkVideo_id = "com.zerozero.hover:id/setting_switch_watermark_video";
	
	//Wifi page
	public String wifiNameInput_id = "com.zerozero.hover:id/setting_connection_camera_name";
	public String showWifiPassword_id = "com.zerozero.hover:id/setting_connection_show_password";
	public String wifiPasswordInput_id = "com.zerozero.hover:id/setting_connection_wifi_password";
	public String wifiPasswordConfirmInput_id = "com.zerozero.hover:id/setting_connection_confirm_password";
	public String wifiInfoChangeBtn_id = "com.zerozero.hover:id/setting_connection_change";
	public String resultTextAfterChangeWifiInfo_id = "android:id/message";
	public String resultTextAfterChangeWifiInfo_1 = "WiFi configuration successfully changed";
	public String resultTextAfterChangeWifiInfo_2 = "Hover Camera not connected.";
	public String resultAlertAfterChangeWifiInfoBtn_id = "android:id/button1";
	
	public String wifiFrequencyBand_id = "com.zerozero.hover:id/setting_connection_frequency_band_content";

	public String wifiOption_id = "android:id/text1";
	public String wifiBandChangeBtn_id = "com.zerozero.hover:id/setting_wifi_change";
	public String wifiBandChangeConfirm_id = "com.zerozero.hover:id/hint_confirm";
	public String wifiBandChangeCancel_id = "com.zerozero.hover:id/hint_cancel";
	public String resultTextAfterChangeWifiBand_id= "com.zerozero.hover:id/hint_text";
	public String resultTextAfterChangeWifiBand = "Hover Camera has switched Wi-Fi band, please reconnect.";
	//factory reset page
	public String factoryResetBtn_id = "com.zerozero.hover:id/setting_factory_reset_reset";
	
	//FeedBack
	public String reportProblem_id = "com.zerozero.hover:id/setting_support_and_feedback_report_problem";
	public String generalFeedBack_id = "com.zerozero.hover:id/setting_support_and_feedback_general_feedback";
	public String sendLog_id = "com.zerozero.hover:id/setting_support_and_feedback_send_log";
	public String cancelBtn_id = "com.zerozero.hover:id/setting_support_and_feedback_cancel";
	
	public void backToLastPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.className(backBtn_class)).click();
	}
	
	public void navToAboutPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(2).click();
	}
	
	public void navToFirmwareUpdatePage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(3).click();
	}
	
	public void navToMemoryManagePage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(4).click();
		Thread.sleep(1000);
	}
	
	public void deleteResourceFromMemory(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(deleteBtn_id)).click();
//		driver.findElement(By.id(deleteAlertConfirm_id));
		driver.tap(1, driver.findElement(By.id(deleteAlertConfirm_id)), 500);
	}
	
	public void navToBeastModePage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(6).click();
	}
	
	public void navToRecordVideoPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(7).click();
	}
	
	public void navToWatermarkPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(8).click();
	}
	
	public void navToSetWifiPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(9).click();
	}
	
	public void changeWifiName(AndroidDriver<WebElement> driver, String wifiName) throws Exception{
		WebElement wifiNameInput = driver.findElement(By.id(wifiNameInput_id));
		wifiNameInput.clear();
		wifiNameInput.sendKeys(wifiName);
	}
	
	public void changeWifiPassword(AndroidDriver<WebElement> driver, String wifiPassword) throws Exception{
		driver.findElement(By.id(showWifiPassword_id)).click();
		WebElement wifiPasswordInput = driver.findElement(By.id(wifiPasswordInput_id));
		wifiPasswordInput.clear();
		wifiPasswordInput.sendKeys(wifiPassword);
		WebElement wifiPasswordConfirmInput = driver.findElement(By.id(wifiPasswordConfirmInput_id));
		wifiPasswordConfirmInput.clear();
		wifiPasswordConfirmInput.sendKeys(wifiPassword);
		driver.pressKeyCode(AndroidKeyCode.BACK);//hide keyboard
	}
	
	public void navToFactoryResetPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(10).click();
	}
	
	public void navToHelpCenterPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(12).click();
	}
	
	public void navToSupportFeedbackPage(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElements(By.className(commonElement_class)).get(13).click();
	}
	
	public void navToTutorialPage(AndroidDriver<WebElement> driver) throws Exception{
		int width = driver.manage().window().getSize().width;
   	 	int height = driver.manage().window().getSize().height;
		driver.swipe(width/2, height*3/4, width/2, height/4, 500);
		driver.findElements(By.className(commonElement_class)).get(9).click();
	}
}
