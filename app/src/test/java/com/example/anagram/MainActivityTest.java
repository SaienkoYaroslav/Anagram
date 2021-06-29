package com.example.anagram;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    private ForTest test;
    private String userIn = "qwerty";
    private String userIgn = "qwe";

    @Before
    public void setUp() {
        test = new ForTest();
        System.out.println("Ready for testing!");
    }

    @After
    public void cleanup() {
        System.out.println("Done with unit test!");
    }

    @BeforeClass
    public static void testClassSetup() {
        System.out.println("Getting test class ready");
    }

    @AfterClass
    public static void testClassCleanup() {
        System.out.println("Done with tests");
    }

    @Test
    public void testReverse() {
        test = new ForTest();
        String result = test.reverse(userIn, userIgn);
        assertEquals("qweytr", result);
    }

}