package com.example.anagram;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

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

    @Test
    public void isDisplayedButtonConvertAfterClick() {
        onView(withId(R.id.buttonConvert)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void typeInputAndIgnoreTextPressButtonCheckResult() {
        onView(withId(R.id.etInputText)).perform(typeText("TestWord123"));
        onView(withId(R.id.etIgnoreText)).perform(clearText()).perform(typeText("Test123"));
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("TestdroW123")));
    }

    @Test
    public void pressButtonWhenBothEditTextsEmpty() {
        onView(withId(R.id.etIgnoreText)).perform(clearText());
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("")));
    }

    @Test
    public void pressButtonWhenEmptyInputTextAndDefaultIgnoreText() {
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("")));

    }

    @Test
    public void typeInputTextAndDefaultIgnoreTextPressButtonCheckResult() {
        onView(withId(R.id.etInputText)).perform(typeText("TestWord123"));
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("321droWtseT")));

    }

    @Test
    public void typeInputTextAndClearIgnoreTextPressButtonCheckResult() {
        onView(withId(R.id.etInputText)).perform(typeText("TestWord123"));
        onView(withId(R.id.etIgnoreText)).perform(clearText());
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("321droWtseT")));

    }

    @Test
    public void typeInputAndIgnoreTextPressButtonCheckResultTwice() {
        onView(withId(R.id.etInputText)).perform(typeText("TestWord123"));
        onView(withId(R.id.etIgnoreText)).perform(clearText()).perform(typeText("Test123"));
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("TestdroW123")));
        onView(withId(R.id.etInputText)).perform(clearText()).perform(typeText("Apple"));
        onView(withId(R.id.etIgnoreText)).perform(clearText()).perform(typeText("le"));
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("ppAle")));

    }


    @Test
    public void typeInputAndIgnoreTextPressButtonCheckResultWrongCase() {
        onView(withId(R.id.etInputText)).perform(typeText("TestWord123"));
        onView(withId(R.id.etIgnoreText)).perform(clearText()).perform(typeText("Test123"));
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("TestdroW12")));
    }

    @Test
    public void typeInputTextAndDefaultIgnoreTextWrongCase() {
        onView(withId(R.id.etInputText)).perform(typeText("TestWord123"));
        onView(withId(R.id.buttonConvert)).perform(click());
        onView(withId(R.id.tvConvertText)).check(matches(withText("3e21droWtsT")));
    }
}