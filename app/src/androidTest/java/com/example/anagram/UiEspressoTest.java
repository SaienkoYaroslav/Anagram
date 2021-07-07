package com.example.anagram;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UiEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void isDisplayedButtonConvertAfterClick() {
        onView(withId(R.id.buttonConvert)).perform(click()).check(matches(isDisplayed()));
    }
    @Test
    public void testingApp_typeInputAndIgnoreTextPressButtonCheckResult() throws Exception {
        onView(withId(R.id.etInputText)).perform(typeText("TestWord123"));
        onView(withId(R.id.etIgnoreText)).perform(clearText()).perform(typeText("Test123"));
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("TestdroW123")));
    }
}