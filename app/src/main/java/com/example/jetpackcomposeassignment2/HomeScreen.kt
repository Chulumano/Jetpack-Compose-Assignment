package com.example.jetpackcomposeassignment2


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
)
{
    MyWelcomeText()
    AlertDialog(navController = navController)
}

}

@Composable
fun MyWelcomeText(){
    Text(
        text ="Welcome to My Jetpack Compose Journey",
        color = Color.Black,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,)
}

@Composable
fun AlertDialog(navController: NavController){
    val openDialog = remember { mutableStateOf(false) }
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor =  Color.Red,
        contentColor = MaterialTheme.colors.surface
    )

    Row{
        Button(
            colors = mainButtonColor,
            onClick = {openDialog.value = true},
            modifier = Modifier.padding(8.dp)
        ){
            Text(text = "Info")
            Icon(imageVector = Icons.Outlined.Info,
                contentDescription = null,)
        }
        Button(

            colors = mainButtonColor,
            onClick = {navController.navigate(route = Screen.Detail.route)},
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = "Start Journey")
            Icon(imageVector = Icons.Outlined.Face,
                contentDescription = null,)
        }}


    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Information", color = Color.White) },
            text = { Text("Hello! Jetpack Compose has made coding android apps so much easier than before." +
                    "It's less time consuming and quicker, you should also try it.", color = Color.White) },
            confirmButton = {
                TextButton(
                    onClick = {
                        navController.navigate(route = Screen.Home.route)
                    }
                ) {  Text("Okay", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        navController.navigate(route = Screen.Home.route)
                    }
                ) { Text("Dismiss", color = Color.White)
                }
            },
            backgroundColor = colorResource(id = R.color.teal_200),
            contentColor = Color.White
        )
    }
}


