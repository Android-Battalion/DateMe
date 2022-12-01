package com.androiders.dateme.features.ui.screens.pages

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object HomeTemp : NavRoutes("home_temp")
    object FromHome : NavRoutes("from_home")
    object Login : NavRoutes(route = "login")
}
