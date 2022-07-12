package com.example.recipebox

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

}

@Composable
fun Scaffold() {
    var recipeName by remember { mutableStateOf("")}
    var mDisplayMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Recipe Box")} ,backgroundColor = MaterialTheme.colors.primary,
                actions = {

                    // Make post icon
                    IconButton(onClick = { Toast.makeText(context, "Make Post", Toast.LENGTH_SHORT).show() }) {
                        Icon(painter = painterResource(id = R.drawable.ic_add_box_24), "")
                    }

                    // View account icon
                    IconButton(onClick = { Toast.makeText(context, "View Account", Toast.LENGTH_SHORT).show() }) {
                        Icon(painter = painterResource(id = R.drawable.ic_account_box), "")
                    }

                    // Dropdown menu
                    IconButton(onClick = { mDisplayMenu = !mDisplayMenu }) {
                        Icon(Icons.Default.MoreVert, "")
                    }
                    DropdownMenu(
                        expanded = mDisplayMenu,
                        onDismissRequest = { mDisplayMenu = false }
                    ) {

                        DropdownMenuItem(onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() }) {
                            Text(text = "Settings")
                        }

                        DropdownMenuItem(onClick = { Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show() }) {
                            Text(text = "Logout")
                        }
                    }
                }
            )},

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
})}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeBoxTheme {
        Scaffold()

    }
}