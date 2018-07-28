package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by marti on 28/07/2018.
 */
@RunWith(AndroidJUnit4.class)
public class Tests {

    private static final String TAG = "TEST";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTask() {
        //onView(withId(R.id.jokeButton)).perform(click());
        Espresso.onView(withId(R.id.jokeButton)).perform(click());
    }

    @Test
    public void AsyncStringTest() {

        String result = null;
        EndPointsAsync endpointsAsyncTask = new EndPointsAsync(getContext(), null);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(TAG, "String is " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
