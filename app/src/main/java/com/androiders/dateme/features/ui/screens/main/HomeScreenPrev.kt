package com.androiders.dateme.features.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.androiders.dateme.core.theme.DateMeTheme

// this is just for previewing purposes. Make sure up to date
@Composable
fun HomePlaPrev() {
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Home Page",
                fontSize = 45.sp
            )

            Text(
                text = "Under Construction",
                fontSize = 25.sp
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Send to next page")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePlaPreview() {
    DateMeTheme {
        HomePlaPrev()
    }
}
