package com.example.jetpackcomposeassignment2

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun DetailScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
       JourneyText(navController = navController)
    }

}

@Composable
fun JourneyText(navController:NavController) {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor =  Color.Red,
        contentColor = MaterialTheme.colors.surface
    )
    Text(
        text ="My name is Chulumanco Buhle Nkwindana. " +
                "I'm currently studying a Diploma in ICT: Application Development. " +
                "My course is under the department Information Technology. " + "My student number is 219390983. ",
        color = Color.Black,
        fontSize = 15.sp,
        textAlign = TextAlign.Center,)

    Row{
        Button(
            colors = mainButtonColor,
            onClick = {navController.navigate(route = Screen.Module.route)},
            modifier = Modifier.padding(8.dp)
        ){
            Text(text = "Current modules")

        }
    }
    Button(
        colors = mainButtonColor,
        onClick = {navController.navigate(route = Screen.Home.route)},
        modifier = Modifier.padding(10.dp)

    ){
        Text(text = "Back")
    }}

