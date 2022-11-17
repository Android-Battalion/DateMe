package com.androiders.dateme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.androiders.dateme.ui.theme.DateMeTheme

class Onboarding : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    
                }
            }
        }
    }
}

@Composable
fun OnboardingDemo() {
    Text(text = "Placeholder")
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    DateMeTheme {
        OnboardingDemo()
    }
}