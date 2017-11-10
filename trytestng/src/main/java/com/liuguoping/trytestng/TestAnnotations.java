package com.liuguoping.trytestng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestAnnotations {
  @Test(enabled = true)
  public void myFuc() {
	  System.out.println("@Test-myFuc02");
  }
  
  @BeforeSuite
  public void testBeforeSuite(){
	  System.out.println("@BeforeSuite-testBeforeSuite");
  }
  
  @BeforeMethod
  public void testBeforeMethod(){
	  System.out.println("@BeforeMethod-testBeforeMethod");
  }
  
  @AfterTest
  public void testAfterTest(){
	  System.out.println("@AfterTest-testAfterTest");
  }
  
}
