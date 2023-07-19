package com.example.szfirstapplication.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.szfirstapplication.screens.AUTHENTICATION_ROUTE
import com.example.szfirstapplication.screens.LoginScreen
import com.example.szfirstapplication.screens.Screen
import com.example.szfirstapplication.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController:NavHostController){
    // Authentication Graph: nested NavGraph
    navigation(
        startDestination = Screen.Login.route,
        route = AUTHENTICATION_ROUTE
    ){
        composable(
            route = Screen.Login.route,
        ){
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.SignUp.route,
        ){
            SignUpScreen(navController = navController)
        }
    }

}