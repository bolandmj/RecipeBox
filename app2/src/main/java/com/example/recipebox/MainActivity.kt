package com.example.recipebox

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipebox.ui.theme.RecipeBoxTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RecipeDetails("Android")
                }
            }
        }
    }
}

@Composable
fun RecipeDetails(name: String) {
    var recipeName by remember { mutableStateOf("")}
    val context = LocalContext.current

    Column {
        OutlinedTextField(
            value = recipeName,
            onValueChange = { recipeName = it },
            label = { Text(stringResource(R.string.recipeName)) }
        )
        Button(
            onClick = {
                Toast.makeText(context, "$recipeName", Toast.LENGTH_LONG).show()
            }
        ) {
            Text(text = "Search")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeBoxTheme {
        RecipeDetails("Android")
    }
}