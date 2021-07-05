package com.example.anagram;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverserTest {
    private Reverser revTest;

    @BeforeEach
    public void setUp() {
        revTest = new Reverser();
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
    void reverser_shouldReturnReverseStringExceptIgnoredCharacters() {
        String result = revTest.reverse("TestWord1", "Test");
        System.out.println("Word from Reverser: " + result);
        assertEquals("Test1droW", result);

    }

    @ParameterizedTest
    @CsvSource({
            "apple, ap, appel",
            "banana, ban, banana",
            "0xF1, 1, Fx01",
    })
    void reverser_shouldReturnReverseStringExceptIgnoredCharactersParameterizedTest(String userInput, String userIgnore, String expected) {
        String result = revTest.reverse(userInput, userIgnore);

            assertEquals(expected, result);

    }
    @ParameterizedTest
    @CsvSource({
            "WrongKing123, 3K, k21gni3gnorW",
            "WrongTest, Test, gnorwtest"
    })
    void reverser_shouldReturnReverseStringExceptIgnoredCharactersWrongCase(String userInput, String userIgnore, String expected) {
        String result = revTest.reverse(userInput, userIgnore);

        assertEquals(expected, result);
    }

}