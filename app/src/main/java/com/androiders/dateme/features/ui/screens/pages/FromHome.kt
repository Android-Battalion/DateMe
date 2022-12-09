package com.androiders.dateme.features.ui.screens.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.androiders.dateme.core.theme.DateMeTheme
import com.androiders.dateme.features.utils.DisplayClock

@Composable
fun FromHome() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        DisplayClock()
    }
}

@Preview(showBackground = true)
@Composable
fun FromHomePreview() {
    DateMeTheme {
        FromHome()
    }
}
