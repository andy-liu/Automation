package com.lgp.demo_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOrder {

	@Before
	public void SetUp(){
		System.out.println("setup!");
	}
	
	@Test
	public void testFirst() {
		System.out.println("1");;
	}
	@Test
	public void testSecond() {
		System.out.println("2");;
	}
	@Test
	public void testThird() {
		System.out.println("3");;
	}
	@After
	public void tearDown(){
		System.out.println("teardown!");
	}
}
