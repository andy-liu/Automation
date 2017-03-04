package com.zerozero.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class MyUtil {
	public MyUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static void MouseHoverByJavaScript(WebElement targetElement, WebDriver driver)
    {
 
        String mouseHoverjs = "var evObj = document.createEvent('MouseEvents');" +
                            "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                            "arguments[0].dispatchEvent(evObj);";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(mouseHoverjs, targetElement);
      }
	
	public static void OpenNewWindow(String url, WebDriver driver){
		JavascriptExecutor JavaScriptExecutor = (JavascriptExecutor)driver;  
		JavaScriptExecutor.executeScript("window.open('" + url + "')");
//	     System.out.println("there are " + driver.getWindowHandles().size() + " windows");  
	}

}
