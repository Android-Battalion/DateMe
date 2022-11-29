package com.androiders.dateme.features.ui

sealed class NavRoutes(val route: String, val name: String) {
    object Home : NavRoutes("home", "Home")
    object HomeTemp : NavRoutes("home_temp", "Home Temp")
}
