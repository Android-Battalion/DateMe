package com.androiders.dateme.navigation

sealed class Screen (val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
}