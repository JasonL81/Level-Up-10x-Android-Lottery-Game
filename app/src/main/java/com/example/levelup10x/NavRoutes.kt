package com.example.levelup10x

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Lottery : NavRoutes("lottery")

}