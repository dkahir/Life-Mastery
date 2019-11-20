package com.devahir.mastery

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.devahir.mastery.ui.welcome.WelcomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WelcomeActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<WelcomeActivity> =
        ActivityTestRule(WelcomeActivity::class.java)

    @Test
    fun testWelcomeActivityShown() {
        onView(withId(R.id.welcome_logo_image_view)).check(matches(isDisplayed()))
    }
}