package com.liuguoping.trytestng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestGroups {
  @Test(groups = "group1")
  public void testFun01() {
	  System.out.println("testFun01");
  }
  
  @Test(groups = "group1")
  public void testFun02() {
	  System.out.println("testFun02");
  }
  
  @Test(groups = "group2")
  public void testFun03() {
	  System.out.println("testFun03");
  }
  
  @Test(groups = "group2")
  public void testFun04() {
	  System.out.println("testFun04");
  }
  
  @AfterTest(groups = "group2")
  public void testAfterTest() {
	  System.out.println("@AfterTest-testAfterTest");
  }
}
