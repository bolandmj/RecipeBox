package com.example.recipebox

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("Home")
    object AddRecipe : NavRoutes("AddRecipe")
}
