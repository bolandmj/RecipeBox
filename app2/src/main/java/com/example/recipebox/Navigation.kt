package com.example.recipebox

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController)
        }
        composable(route = Screen.PostScreen.route){
            PostScreen()
        }
    }
}

@Composable
fun MainScreen(navController: NavController){
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
                    IconButton(
                        onClick = {
                            navController.navigate((Screen.PostScreen.route))
                        }) {
                        Icon(painter = painterResource(id = R.drawable.ic_add_box_24), "")
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
            )
        }

    ) { padding ->
        Column(modifier = Modifier.padding(10.dp)) {
            //Temporary
            Button(
                onClick = {

                }
            ) {
                Text(text = "Cheeseburger", modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {

                }
            ) {
                Text(text = "Chicken Tacos", modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {

                }
            ) {
                Text(text = "Lasagna", modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp))
            }

        }

    }
}

@Composable
fun PostScreen(){
    var recipeName by remember { mutableStateOf("")}
    var ingredients by remember { mutableStateOf("")}
    var directions by remember { mutableStateOf("")}
    val context = LocalContext.current

    Column(modifier = Modifier.padding(10.dp)) {
        //RecipeName
        Text(text = "Enter Name of Recipe:")
        OutlinedTextField(
            value = recipeName,
            onValueChange = { recipeName = it },
            label = { Text(stringResource(R.string.recipeName)) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        //Ingredients
        Text(text = "Enter Ingredients for Recipe:")
        OutlinedTextField(
            value = ingredients,
            onValueChange = { ingredients = it},
            label = { Text(stringResource(R.string.ingredients)) },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        //Directions
        Text(text = "Enter How To Cook Recipe:")
        OutlinedTextField(
            value = directions,
            onValueChange = { directions = it},
            label = { Text(stringResource(R.string.directions)) },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Button(
            onClick = {
                Toast.makeText(context, "$recipeName saved", Toast.LENGTH_LONG).show()
                //save()
            }
        ) {
            Text(text = "Save Recipe", modifier = Modifier.fillMaxWidth())
        }


    }

}

@Composable
fun cheeseburger(){

}

