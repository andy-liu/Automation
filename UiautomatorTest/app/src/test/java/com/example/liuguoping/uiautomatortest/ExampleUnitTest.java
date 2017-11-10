package com.example.liuguoping.uiautomatortest;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Before
    public void setUP() throws Exception{
        System.out.print("test");
//        Log.println(Log.WARN, "test", "setUP");

    }

    @After
    public void tearDown() throws Exception{
//        Log.println(Log.WARN, "test", "tearDown");
        System.out.print("test");
    }

    @Test
    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//        Log.println(Log.WARN, "test", "test");
        System.out.print("test");
    }
}