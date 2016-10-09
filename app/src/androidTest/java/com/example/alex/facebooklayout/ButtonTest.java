package com.example.alex.facebooklayout;

import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ButtonTest {

    @Rule
    public ActivityTestRule<ThirdActivity> mActivityRule = new ActivityTestRule<>(
            ThirdActivity.class);


    @Test
    public void onClickChangeTextView(){
        onView(withId(R.id.clickMe)).perform(ViewActions.click());
        onView(withId(R.id.textView)).check(matches(withText(R.string.clicked)));
    }
}
