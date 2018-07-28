package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by marti on 28/07/2018.
 */
@RunWith(AndroidJUnit4.class)
public class Tests {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTask() {
        //onView(withId(R.id.jokeButton)).perform(click());
        Espresso.onView(withId(R.id.jokeButton)).perform(click());
    }

}
