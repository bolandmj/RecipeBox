package com.example.recipebox

import android.app.Activity.RESULT_OK
import android.content.ContentValues.TAG
import android.graphics.drawable.VectorDrawable
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipebox.Scaffold
import com.example.recipebox.dto.Recipe
import com.example.recipebox.ui.theme.RecipeBoxTheme
import com.example.recipebox.ui.theme.White
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

var user: FirebaseUser? = FirebaseAuth.getInstance().currentUser

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

						setContentView(R.layout.activity_main)

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

					//Searchbar
					IconButton(onClick = { Toast.makeText(context, "Search for Recipe", Toast.LENGTH_SHORT).show() }) {
						Icon(painter = painterResource(id = R.drawable.ic_search), "")
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
			)}

	) { padding ->
			Column(modifier = Modifier.padding(10.dp)) {
				OutlinedTextField(
					value = recipeName,
					onValueChange = { recipeName = it },
					label = { Text(stringResource(R.string.recipeName)) },
					modifier = Modifier.fillMaxWidth()
				)
				Button(
					onClick = {
						Toast.makeText(context, "$recipeName", Toast.LENGTH_LONG).show()
						signIn()
					}
				) {
					Text(text = "Search", modifier = Modifier.fillMaxWidth())
				}

				//Temporary
				Text(text="Recipe 1", modifier = Modifier
					.background(MaterialTheme.colors.secondary)
					.fillMaxWidth()
					.padding(vertical = 50.dp))
				Text(text="Recipe 2", modifier = Modifier
					.background(MaterialTheme.colors.secondary)
					.fillMaxWidth()
					.padding(vertical = 50.dp))
				Text(text="Recipe 3", modifier = Modifier
					.background(MaterialTheme.colors.secondary)
					.fillMaxWidth()
					.padding(vertical = 50.dp))
				Text(text="Recipe 4", modifier = Modifier
					.background(MaterialTheme.colors.secondary)
					.fillMaxWidth()
					.padding(vertical = 50.dp))
				Text(text="Recipe 5", modifier = Modifier
					.background(MaterialTheme.colors.secondary)
					.fillMaxWidth()
					.padding(vertical = 50.dp))

		    }

	    }
}



//Quick note for how to save recipe on button click when function is made:
//var recipe = Recipe()
//viewModel.save(recipe)

/*How to make a user sign in on button click (Would be when user tries to make post):
Button(
	onClick = {
		signIn()
	}
){
	Text(text = "Logon")
}
 */



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	RecipeBoxTheme {
		Scaffold()
	}
}

private fun signIn() {
	val providers = arrayListOf(
		AuthUI.IdpConfig.EmailBuilder().build()
	)
	val signinIntent = AuthUI.getInstance()
		.createSignInIntentBuilder()
		.setAvailableProviders(providers)
		.build()

	//signInLauncher.launch(signinIntent)
}
/*
//Need to figure out what dependency is missing for registerForActivityResult()!!!
private val signInLauncher = registerForActivityResult (
	FirebaseAuthUIActivityResultContract()
) {
		res -> this.signInResult(res)
}
*/

private fun signInResult(result: FirebaseAuthUIAuthenticationResult){
	val response = result.idpResponse
	if (result.resultCode == RESULT_OK) {
		user = FirebaseAuth.getInstance().currentUser
	}else{
		Log.e("MainActivity.kt", "Error logging in " + response?.error?.errorCode)
	}
}




