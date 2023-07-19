package com.example.szfirstapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.szfirstapplication.screens.HOME_ROUTE
import com.example.szfirstapplication.screens.ROOT_ROUTE


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    //ROOT NAV GRAPH
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE
    ) {
        homeNavGraph(navController)
        authNavGraph(navController)
    }
}