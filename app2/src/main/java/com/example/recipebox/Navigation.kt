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
        composable(route = Screen.Cheeseburger.route){
            Cheeseburger(navController = navController)
        }
        composable(route = Screen.Taco.route){
            Taco(navController = navController)
        }
        composable(route = Screen.ChickenParm.route){
            ChickenParm(navController = navController)
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

            Button(
                onClick = {
                    navController.navigate((Screen.Cheeseburger.route))
                }
            ) {
                Text(text = "Cheeseburger", modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    navController.navigate((Screen.Taco.route))
                }
            ) {
                Text(text = "Chicken Tacos", modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    navController.navigate((Screen.ChickenParm.route))
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
fun Cheeseburger(navController: NavController){
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
            Text(text="Cheeseburger", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth())

            Text(text="Buns, Ground Beef, Salt, Pepper, American Cheese, Ketchup", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth()
                .padding(vertical = 50.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text="Form the ground beef into patties, then season with salt and pepper. Cook on medium heat 5 minutes each side. Add Cheese 1 minute before done. Put on bun and add ketchup.", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth()
                .padding(vertical = 50.dp))
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}

@Composable
fun Taco(navController: NavController){
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
            Text(text="Chicken Tacos", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth())

            Text(text="2 Chicken breasts, Taco Seasoning, Cheese, Lettuce, Tortillas", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth()
                .padding(vertical = 50.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text="Season chicken with half the bag of seasoning and cook for 30 minutes at 350. Shred chicken and add more seasoning. Put in tortilla and add your toppings", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth()
                .padding(vertical = 50.dp))
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}

@Composable
fun ChickenParm(navController: NavController){
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
            Text(text="Chicken Parmesan", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth())

            Text(text="Chicken Breast, Salt, Pepper, Tomato Sauce, Parmesan, Shredded Mozzarella", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth()
                .padding(vertical = 50.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text="Season and bread chicken breasts. Top with sauce, mozzarella and parmesan. Bake for 30 minutes at 350.", modifier = Modifier
                .background(MaterialTheme.colors.secondary)
                .fillMaxWidth()
                .padding(vertical = 50.dp))
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}

