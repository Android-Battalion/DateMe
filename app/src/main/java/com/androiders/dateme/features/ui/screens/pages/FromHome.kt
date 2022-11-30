package com.androiders.dateme.features.ui.screens.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.androiders.dateme.core.theme.DateMeTheme

@Composable
fun FromHome() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun FromHomePreview() {
    DateMeTheme {
        FromHome()
    }
}
