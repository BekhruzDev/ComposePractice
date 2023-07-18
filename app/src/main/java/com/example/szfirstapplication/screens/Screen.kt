package com.example.szfirstapplication.screens

const val DETAIL_ARGUMENT_ID = "id"
const val DETAIL_ARGUMENT_NAME = "name"
const val PROFILE_ARGUMENT_ID = "id"
const val PROFILE_ARGUMENT_NAME = "name"
sealed class Screen(val route:String){
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
}