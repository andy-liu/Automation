package com.example.liuguoping.uiautomatortest.pages;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import android.util.Log;

import java.util.List;

/**
 * Created by liuguoping on 2017/8/7.
 */


public class BasePage {
    private UiDevice mDevice;
    BasePage(UiDevice currentDevice){
        mDevice = currentDevice;
    }

    public UiObject2 findElementById(String res){
        return mDevice.wait(Until.findObject(By.res(res)), 3000);
    }

    public List <UiObject2> findElementsById(String res){
        return mDevice.wait(Until.findObjects(By.res(res)), 3000);
    }

    public UiObject2 findElementByClassName(String className){
        return mDevice.wait(Until.findObject(By.clazz(className)), 3000);
    }

    public UiObject2 findElementByText(String text){
        return mDevice.wait(Until.findObject(By.text(text)), 3000);
    }

    public UiObject2 findElementByTextContains(String substring){
        return mDevice.wait(Until.findObject(By.textContains(substring)), 3000);
    }

    public UiObject2 findElementBydesc(String contentDescription){
        return mDevice.wait(Until.findObject(By.desc(contentDescription)), 3000);
    }

    public boolean isElementExist(String locator, String locatorType){
        if (locatorType.equals("id"))
            return mDevice.wait(Until.hasObject(By.res(locator)), 3000);
        else if (locatorType.equals("classname"))
            return mDevice.wait(Until.hasObject(By.clazz(locator)), 3000);
        else if (locatorType.equals("text"))
            return mDevice.wait(Until.hasObject(By.text(locator)), 3000);
        else
            return false;
    }
}
