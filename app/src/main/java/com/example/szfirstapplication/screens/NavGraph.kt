package com.example.szfirstapplication.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(
            route = Screen.Home.route
        ) { HomeScreen(navController) }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType },
            )
        ) {
            Log.d("Detail Screen", "passed id: ${it.arguments?.getInt("id")}")
            Log.d("Detail Screen", "passed name: ${it.arguments?.getString("name")}")
            DetailScreen(navController)
        }

        composable(
            route = Screen.Profile.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0 //if optional
                },
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Nothing" //if optional
                },
            )
        ) {
            Log.d("Profile Screen", "passed id: ${it.arguments?.getInt("id")}")
            Log.d("Profile Screen", "passed name: ${it.arguments?.getString("name")}")
            ProfileScreen(navController)
        }
    }
}