package com.carlostorres.alltopics.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carlostorres.alltopics.ui.home.HomeScreen

@Composable
fun NavManager() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
    ) {

        //Pantalla principal
        composable(
            route = NavRoutes.Home.route
        ) {
            HomeScreen()
        }

    }

}