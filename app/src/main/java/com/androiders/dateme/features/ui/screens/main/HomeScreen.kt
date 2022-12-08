package com.androiders.dateme.features.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.androiders.dateme.features.ui.screens.pages.NavRoutes

@Composable
fun HomePla(navController: NavController) {
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
            Button(
                onClick =
                {
                    navController.navigate(NavRoutes.FromHome.route)
                }
            ) {
                Text(text = "Send to next page")
            }
            Button(
                onClick =
                {
                    navController.navigate(NavRoutes.Login.route)
                }
            ) {
                Text(text = "Send to Login Page")
            }
        }
    }
}

// @Preview(showBackground = true)
// @Composable
// fun HomePlaPreview() {
//    DateMeTheme {
//        HomePla()
//    }
// }
