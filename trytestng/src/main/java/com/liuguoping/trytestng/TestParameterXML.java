package com.liuguoping.trytestng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class TestParameterXML {
	
  @Test
  @Parameters({"name", "city"})
  public void getParameterFromXml(String name, String city) {
	 
	  System.out.println("This is " + name + ", I come from " + city + "!");
  }
  
  @DataProvider(name = "providerNumbers")
  public Object[][] numbers() {
      return new Object[][] { { 10, 20 }, { 100, 110 }, { 200, 210 } };
  }

  @Test(dataProvider = "providerNumbers")
  public void getParameterFromDataProvider(int number1, int number2){
	  System.out.println("First" + number1 + " second" + number2);
  }
}
