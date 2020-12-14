package com.example.lab2e;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.MediumTest;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWhenTextStringIsEnteredToTxtMain() {
        final String givenString = "Hello   world   with    extra    empty spaces  ";
        final String expectedResult = "Number of words:6";

        onView(withId(R.id.editText)).perform(click(), replaceText(givenString), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.twOutput)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenEmptyStringIsEnteredToTxtMain() {
        final String givenString = "";
        final String expectedResult = "";

        onView(withId(R.id.editText)).perform(click(), replaceText(givenString), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.twOutput)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenEmptyStringIsEnteredToTxtMainAndCharacterModeSelected() {
        final String givenString = "";
        final String expectedResult = "";

        onView(withId(R.id.editText)).perform(click(), replaceText(givenString), closeSoftKeyboard());
        onView(withId(R.id.dropdown)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.twOutput)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenTextStringIsEnteredToTxtMainAndCharacterModeSelected() {
        final String givenString = "Hello   world   with    extra    empty spaces  ";
        final String expectedResult = "Number of characters:47";

        onView(withId(R.id.editText)).perform(click(), replaceText(givenString), closeSoftKeyboard());
        onView(withId(R.id.dropdown)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.twOutput)).check(matches(withText(expectedResult)));
    }
}