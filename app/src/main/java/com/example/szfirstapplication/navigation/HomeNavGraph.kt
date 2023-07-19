package com.example.szfirstapplication.navigation

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.szfirstapplication.screens.*

fun NavGraphBuilder.homeNavGraph(navController:NavHostController){

    navigation(
        startDestination = Screen.Home.route,
        route = HOME_ROUTE
    ){
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