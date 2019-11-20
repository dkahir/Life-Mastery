package com.devahir.mastery

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.devahir.mastery.ui.login.LoginActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    private lateinit var usernameToBetyped: String
    private lateinit var passwordToBetyped: String

    @get:Rule
    var activityRule: ActivityTestRule<LoginActivity> =
        ActivityTestRule(LoginActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        usernameToBetyped = "username"
        passwordToBetyped = "Password"
    }

    @Test
    fun testLoginActivityShown() {
        onView(withId(R.id.login_logo_image_view)).check(matches(isDisplayed()))
    }

    @Test
    fun testLoginScreen() {
        onView(withId(R.id.username_textInputEditText))
            .perform(click(), typeText(usernameToBetyped))

        onView(withId(R.id.password_textInputEditText))
            .perform(click(), typeText(passwordToBetyped), closeSoftKeyboard())

        onView(withId(R.id.login_button)).check(matches(isClickable()))

        onView(withText(usernameToBetyped)).check(matches(isDisplayed()))
        onView(withText(passwordToBetyped)).check(matches(isDisplayed()))
    }

    @Test
    fun testInvalidUserName() {
        onView(withId(R.id.username_textInputEditText))
            .perform(click(), typeText(""))

        onView(withId(R.id.password_textInputEditText))
            .perform(click(), typeText(passwordToBetyped), closeSoftKeyboard())

        onView(withId(R.id.login_button)).perform(click())

        onView(withText(R.string.invalid_username)).check(matches(isDisplayed()))
    }

    @Test
    fun testInvalidPassword() {
        onView(withId(R.id.password_textInputEditText))
            .perform(click(), typeText(""))

        onView(withId(R.id.username_textInputEditText))
            .perform(click(), typeText(usernameToBetyped), closeSoftKeyboard())

        onView(withId(R.id.login_button)).perform(click())

        onView(withText(R.string.invalid_password)).check(matches(isDisplayed()))
    }
}