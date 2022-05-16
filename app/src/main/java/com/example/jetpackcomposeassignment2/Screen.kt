package com.example.jetpackcomposeassignment2

sealed class Screen (val route:String){
    object Home:Screen(route= "home_screen")
    object Detail:Screen(route= "detail_screen")
    object Module:Screen(route="module_screen")
}
