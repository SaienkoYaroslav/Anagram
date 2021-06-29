package com.example.anagram;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    private MainActivity main;

    @Before
    public void setUp() {
        main = new MainActivity();
    }

    @Test
    public void reverse() {
        assertEquals("qweytr", main.reverse("qwerty", "qwe"));
    }

}