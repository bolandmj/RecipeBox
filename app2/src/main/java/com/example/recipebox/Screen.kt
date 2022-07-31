package com.example.recipebox

sealed class Screen(val route : String){
    object MainScreen : Screen("main_screen")
    object PostScreen : Screen("post_screen")
    object Cheeseburger : Screen("cheeseburger")
    object Taco : Screen("taco")
    object Lasagna : Screen("lasagna")
}
