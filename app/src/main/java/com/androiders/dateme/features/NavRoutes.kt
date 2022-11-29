package com.androiders.dateme.features

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object HomeTemp : NavRoutes("home_temp")
}
