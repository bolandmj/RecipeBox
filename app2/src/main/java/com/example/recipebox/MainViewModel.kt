package com.example.recipebox

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.recipebox.dto.Recipe
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class MainViewModel : ViewModel() {

    private lateinit var firestore : FirebaseFirestore

    init{
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    //Pass in recipe object to function when that is created (ex: save(specimen: Specimen)
    fun save(){
        val document = firestore.collection("recipes").document()
        //example for when post function is made:
        //specimen.specimenId = document.id
        //val handle = document.set(specimen)
        //handle.addOnSuccessListener { Log.d("Firebase", "Document Saved" }
        //handle.addOnFailureListener { Log.e("Firebase", "Save failed $it " }
/*
        Recipe.recipeId = document.id
        val handle = document.set(recipe)
        handle.addOnSuccessListener { Log.d("Firebase", "Document Saved") }
        handle.addOnFailureListener { Log.e("Firebase", "Save failed $it ") }
*/
    }
}