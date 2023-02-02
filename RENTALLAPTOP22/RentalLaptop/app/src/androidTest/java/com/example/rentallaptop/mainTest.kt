package com.example.rentallaptop

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.rentallaptop.main_ui.maintance.MaintanceActivity
import org.hamcrest.core.AllOf
import org.jetbrains.anko.Android
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class  mainTest{
    @Rule @JvmField
    var activityTestRule = ActivityTestRule(MaintanceActivity::class.java)

    @Test
    fun clicksend(){
        onView(withId(R.id.Keluhan)).perform(ViewActions.typeText( "laptop rusak"))
        onView(withId(R.id.button6)).perform(ViewActions.click())
        onView(withId(R.id.send)).perform(ViewActions.click())
        onView(withId(R.id.savekeluhan))
            .check(ViewAssertions.matches(ViewMatchers.withText("laptop rusak")))
    }
}

