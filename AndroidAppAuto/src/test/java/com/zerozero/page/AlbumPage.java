package com.zerozero.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AlbumPage {
	public AlbumPage() {
		// TODO Auto-generated constructor stub
	}

	public String dateInfo_Id = "com.zerozero.hover:id/header_text";
	public String textEmpty_Id = "com.zerozero.hover:id/tvTextEmpty";
	public String imgThumb_Id= "com.zerozero.hover:id/image_thumb";
	public String imgThumbSelected_Id = "com.zerozero.hover:id/image_selected";
	public String imgViewBackBtn = "com.zerozero.hover:id/btn_album_back";
	public String cancelSlectedBtn_Id = "com.zerozero.hover:id/btn_album_cancel";
	public String selectAllBtn_Id = "com.zerozero.hover:id/btn_album_select_all";
	public String deselectAllBtn_Id = "com.zerozero.hover:id/btn_album_select_all";
	public String imagSelected_Id = "com.zerozero.hover:id/image_selected";
	public String imgSelectionText_Id= "com.zerozero.hover:id/text_selection_info";
	public String textView_class = "android.widget.TextView";
	public String deleteBtn_Id = "com.zerozero.hover:id/btn_album_delete";
	public String shareBtn_Id = "com.zerozero.hover:id/btn_album_share";
	
	public String alertMessage_Id= "android:id/message";
	public String delConfirmBtn = "com.zerozero.hover:id/hint_confirm";
	public String delConcelBtn = "com.zerozero.hover:id/hint_cancel";
	
	public String shareFacebook_Id = "com.zerozero.hover:id/dialog_share_facebook";
	public String shareInstagram_Id = "com.zerozero.hover:id/dialog_share_instagram";
	public String shareTwitter_Id = "com.zerozero.hover:id/dialog_share_twitter";
	public String shareWeibo_Id = "com.zerozero.hover:id/dialog_share_weibo";
	public String shareWechat_Id = "com.zerozero.hover:id/dialog_share_wechat";
	public String shareWechatTimeline_Id = "com.zerozero.hover:id/dialog_share_wechat_timeline";
	public String closeShareDialogBtn_Id = "com.zerozero.hover:id/dialog_share_close";
	
	
	
	public int openOneImg(AndroidDriver<WebElement> driver) throws Exception{
		List<WebElement> imgList = driver.findElements(By.id(imgThumb_Id));
		imgList.get(0).click();
		return imgList.size();
	}
	
	public void backFromBigImgView(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(imgViewBackBtn)).click();
	}
	
	public void openImgOneByOne(AndroidDriver<WebElement> driver) throws Exception{
		List<WebElement> imgList = driver.findElements(By.id(imgThumb_Id));
		
		for(int i=0;i<imgList.size();i++){
			imgList.get(i).click();
			driver.findElement(By.id(imgViewBackBtn)).click();
		}
	}
	
	public void selectImg(AndroidDriver<WebElement> driver, int selectCount) throws Exception{
		List<WebElement> imgList = driver.findElements(By.id(imgThumb_Id));
		driver.tap(1, imgList.get(0), 1000);
		for(int i=1; i<=selectCount; i++){
			imgList.get(i).click();
		}
	}
	
	public void deselectImg(AndroidDriver<WebElement> driver, int deselectCount) throws Exception {
		List<WebElement> imgList = driver.findElements(By.id(imgThumbSelected_Id));
		for(int i=0; i<deselectCount; i++){
			imgList.get(i).click();
		}
	}
	
	public void cancelSelectStatus(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(cancelSlectedBtn_Id)).click();
	}
	
	public void selectAll(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(selectAllBtn_Id)).click();
	}
	
	public void deselectAll(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(deselectAllBtn_Id)).click();
	}
	
	public void delAllImg(AndroidDriver<WebElement> driver) throws Exception{
		List<WebElement> imgList = driver.findElements(By.id(imgThumb_Id));
		driver.tap(1, imgList.get(0), 1000);
		driver.findElement(By.id(selectAllBtn_Id)).click();
		driver.findElement(By.id(deleteBtn_Id)).click();
		driver.findElement(By.id(delConfirmBtn)).click();
	}
	
	public void delAllImgOneByOne(AndroidDriver<WebElement> driver) throws Exception{
		List<WebElement> imgList = driver.findElements(By.id(imgThumb_Id));
		imgList.get(0).click();
		for (int i=0; i<imgList.size(); i++){
			driver.findElement(By.id(deleteBtn_Id)).click();
			driver.findElement(By.id(delConfirmBtn)).click();
		}

	}
	
	public void openShareDialogInImgList(AndroidDriver<WebElement> driver) throws Exception{
		List<WebElement> imgList = driver.findElements(By.id(imgThumb_Id));
		driver.tap(1, imgList.get(0), 1000);
		driver.findElement(By.id(shareBtn_Id)).click();
	}
	
	public void openShareDialogInBigImg(AndroidDriver<WebElement> driver) throws Exception{
		List<WebElement> imgList = driver.findElements(By.id(imgThumb_Id));
		imgList.get(0).click();
		driver.findElement(By.id(shareBtn_Id)).click();
	}
	
	public void closeShareDialog(AndroidDriver<WebElement> driver) throws Exception{
		driver.findElement(By.id(closeShareDialogBtn_Id)).click();
	}
}
