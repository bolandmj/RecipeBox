package com.example.recipebox

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipebox.Scaffold
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
                    Scaffold()
                }
            }

        }
    }
}

@Composable
fun Scaffold() {
    var recipeName by remember { mutableStateOf("")}
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = {Text("Recipe Box")},backgroundColor = MaterialTheme.colors.primary)  },
        content = { padding ->
            Column(modifier = Modifier
                .padding(padding)) {
                Text("Welcome to Recipe Box! [ADD CONTENT HERE IN SCAFFOLD]")
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
        },
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeBoxTheme {
        Scaffold()
    }
}