package com.example.szfirstapplication.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

const val DETAIL_ARGUMENT_ID = "id"
const val DETAIL_ARGUMENT_NAME = "name"
const val PROFILE_ARGUMENT_ID = "id"
const val PROFILE_ARGUMENT_NAME = "name"

const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"
const val AUTHENTICATION_ROUTE = "authentication"
sealed class Screen(open val route:String){
    object Home:Screen(route = "home_screen")
    object Detail:Screen(route = "detail_screen/{id}/{name}"){
       /** Required arguments are passed with slash ' / ' */
        fun passArgs(id:Int, name:String):String{
            return "detail_screen/$id/$name"
       }
    }
    object Profile:Screen(route = "profile_screen?id={id}&name={name}"){
        /** Optional arguments are passed with question mark ' ? ' */
        fun passArgs(id: Int = 6, name: String = "Ibrokhim"):String{
            return "profile_screen?id=$id&name=$name"
        }
    }
    object Login:Screen(route = "login_screen")
    object SignUp:Screen(route = "signup_screen")
}

sealed class BottomNavigationScreen(
    val route: String,
    val title:String,
    val icon: ImageVector,
){
    object Main:BottomNavigationScreen(
        route = "main_screen",
        title = "Main",
        icon = Icons.Default.Home
    )
    object Statistics:BottomNavigationScreen(
        route = "statistics_screen",
        title = "Statistics",
        icon = Icons.Default.Search
    )
    object Settings:BottomNavigationScreen(
        route = "settings_screen",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}