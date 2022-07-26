package com.example.recipebox.dto

data class Recipe(var recipeName : String, var ingredients : String, var directions : String) {
    override fun toString(): String{
        return recipeName
    }
}