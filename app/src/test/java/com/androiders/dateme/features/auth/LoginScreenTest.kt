package com.androiders.dateme.features.auth

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.androiders.dateme.features.ui.screens.login.LoginScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"])
class LoginScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `check login button exists`() {

        composeTestRule.setContent {
            LoginScreen()
        }

        composeTestRule.onNodeWithTag("login_button")
        composeTestRule.onNodeWithTag("login_button").assertTextEquals("Login")
    }

    @Test
    fun `check button is clickable`() {
        composeTestRule.setContent {
            LoginScreen()
        }
        composeTestRule.onNodeWithTag("login_button")
        composeTestRule.onNodeWithTag("login_button").assertHasClickAction()
    }

    @Test
    fun `check forgot password exists and is clickable`() {
        composeTestRule.setContent {
            LoginScreen()
        }

        composeTestRule.onNodeWithTag("forgot_pwd")
        composeTestRule.onNodeWithTag("forgot_pwd").assertTextEquals("Forgot Password")
        composeTestRule.onNodeWithTag("forgot_pwd").assertHasClickAction()
    }
}
