package com.carlostorres.alltopics.ui.navigation

sealed class NavRoutes (val route: String) {

    object Home : NavRoutes(route = "Home")

}