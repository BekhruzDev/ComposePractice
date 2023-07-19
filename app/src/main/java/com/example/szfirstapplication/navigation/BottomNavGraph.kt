package com.example.szfirstapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.szfirstapplication.screens.BottomNavigationScreen
import com.example.szfirstapplication.screens.MainScreen
import com.example.szfirstapplication.screens.SettingsScreen
import com.example.szfirstapplication.screens.StatisticsScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationScreen.Main.route
    ) {
        composable(route = BottomNavigationScreen.Main.route){
            MainScreen(navHostController = navHostController)
        }
        composable(route = BottomNavigationScreen.Statistics.route){
            StatisticsScreen(navHostController = navHostController)
        }
        composable(route = BottomNavigationScreen.Settings.route){
            SettingsScreen(navHostController = navHostController)
        }
    }
}
