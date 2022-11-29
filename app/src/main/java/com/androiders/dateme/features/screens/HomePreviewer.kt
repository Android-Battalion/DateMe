package com.androiders.dateme.features.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.androiders.dateme.core.theme.DateMeTheme

@Composable
fun HomePla() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Under Construction",
                fontSize = 25.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePlaPreview() {
    DateMeTheme {
        HomePla()
    }
}
