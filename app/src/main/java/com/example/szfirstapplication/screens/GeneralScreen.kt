package com.example.szfirstapplication.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.szfirstapplication.navigation.BottomNavGraph

@Composable
fun GeneralScreen(){
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navHostController)}
    ) {
        BottomNavGraph(navHostController = navHostController)
    }
}

@Composable
fun BottomBar(navHostController: NavHostController){
    val screens = listOf(
        BottomNavigationScreen.Main,
        BottomNavigationScreen.Statistics,
        BottomNavigationScreen.Settings
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation{
        screens.forEach { screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navHostController = navHostController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen:BottomNavigationScreen,
    currentDestination: NavDestination?,
    navHostController: NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Icon")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        selectedContentColor = Color.Green,
        onClick = {
            navHostController.navigate(screen.route){
                popUpTo(navHostController.graph.startDestinationId)
                launchSingleTop = true //if the destination is already on top of the back stack, it won’t be recreated, just resumed
            }
        }
    )
}