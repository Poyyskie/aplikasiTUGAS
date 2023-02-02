package com.example.espreso

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.AllOf
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class mainTest{
    @Rule @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clickUppercaseButton(){
        onView(withId(R.id.nama)).perform(ViewActions.typeText("Hello World"))
        onView(withId(R.id.myUppercase)).perform(ViewActions.click())
        onView(withId(R.id.nama)).check(matches(withText("HELLO WORLD")))
    }

    @Before
    fun setUp (){
        Intents.init()

    }
    @Test
    fun launchBrowser(){
        var expectedIntents : org.hamcrest.Matcher<Intent>? =
            allOf()
                hasAction(Intent.ACTION_VIEW);
                hasData(Uri.parse("https://www.mikroskil.ac.id/"))

        onView(withId(R.id.startSecondActivity)).perform(click())
        intended(expectedIntents)

    }
    @After
    fun tearDown(){
        Intents.release()
    }
}

