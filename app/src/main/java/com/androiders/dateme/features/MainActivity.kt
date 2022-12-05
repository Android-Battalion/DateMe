package com.androiders.dateme.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.androiders.dateme.core.theme.DateMeTheme
import com.androiders.dateme.features.onboarding.ui.screen.OnBoardingScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isSplashScreen = mutableStateOf(true)

        lifecycleScope.launch(Dispatchers.Default) {
            delay(3000)
            isSplashScreen.value = false
        }

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                isSplashScreen.value
            }
        }

        setContent {
            DateMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    OnBoardingScreen()
                }
            }
        }
    }
}
