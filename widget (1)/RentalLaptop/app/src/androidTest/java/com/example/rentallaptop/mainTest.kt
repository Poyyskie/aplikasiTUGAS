package com.example.rentallaptop


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.rentallaptop.main_ui.maintance.MaintanceActivity


import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class  mainTest{
    @Rule @JvmField
    var activityTestRule = ActivityTestRule(MaintanceActivity::class.java)

    @Test
    fun clicksend(){
        onView(withId(R.id.send)).perform(click())
        onView(withId(R.id.Keluhan)).perform(ViewActions.typeText( "pengujian espresso di dalam maintance"))
        onView(withId(R.id.button6)).perform(click())
        onView(withId(R.id.savekeluhan))
            .check(ViewAssertions.matches(ViewMatchers.withText("pengujian espresso di dalam maintance")))
    }
}

