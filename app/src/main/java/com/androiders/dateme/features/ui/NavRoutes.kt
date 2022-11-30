package com.androiders.dateme.features.ui

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object HomeTemp : NavRoutes("home_temp")
    object FromHome : NavRoutes("from_home")
}
