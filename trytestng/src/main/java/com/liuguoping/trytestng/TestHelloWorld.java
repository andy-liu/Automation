package com.liuguoping.trytestng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHelloWorld {
  @Test(enabled = true, groups = "group2")
  public void myFunc(){
	  System.out.println("@Test-myFunc");
  }
  
  @BeforeTest(groups = "group2")
  public void testBeforeTest(){
	  System.out.println("@BeforeTest-testBeforeTest");
  }
  
  @AfterTest(groups = "group2")
  public void testAfterTest(){
	  System.out.println("@AfterTest-testAfterTest");
  }
  
  @AfterMethod(groups = "group2")
  public void testAfterMethod(){
	  System.out.println("@AfterMethod-testAfterMethod");
  }
}
