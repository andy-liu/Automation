package com.zerozero.testcase;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class TestCommond {

	@Test
	public void test() throws Exception{
//		Runtime.getRuntime().exec("C:");
//		Runtime.getRuntime().exec("cd /users/liuguoping/Downloads");
//		Process proc = Runtime.getRuntime().exec("adb install app-product-release.apk");
		Runtime runtime = Runtime.getRuntime(); 
//		runtime.exec("cmd /c C:");
//		runtime.exec("cmd /c cd /users/liuguoping/Downloads");
		Process proc = runtime.exec("adb install C:\\Users\\liuguoping\\Downloads\\app-product-release.apk");
		BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
		String line = null;
		while ((line = input.readLine()) != null) { 
			System.out.println(line); 
		   } 
	}

}
