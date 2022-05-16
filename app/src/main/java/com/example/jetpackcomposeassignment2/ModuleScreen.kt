package com.example.jetpackcomposeassignment2


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.system.exitProcess

@Composable
fun ModuleScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

        ){

        Modules(navController = navController)
        Alert(navController = navController)

    }
}

@Composable
fun Modules(navController: NavController) {
    Text(
        text ="My modules",
        fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)

    Text(
        text = " 1. Applications Development Practice- ADP372S",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
    Text(
        text ="  Year-round theory and practical module",
        fontSize = 14.sp, textAlign = TextAlign.Center,)
    Text(
        text =" 2. Applications Development Theory - ADT372S",
        fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)
    Text(
        text ="Year-round theory module",
        fontSize = 14.sp, textAlign = TextAlign.Center,)
    Text(
        text =" 3. ICT elective - ICE362S",
        fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)
    Text(
        text ="Semester theory and practical module",
        fontSize = 14.sp, textAlign = TextAlign.Center,)
    Text(
        text =" 4. Information Systems - ITS362S",
        fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)
    Text(
        text ="Year-round theory and practical module",
        fontSize = 14.sp, textAlign = TextAlign.Center,)
    Text(
        text =" 5. Professional Practice - PFP362S",
        fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)
    Text(
        text ="Semester theory module",
        fontSize = 14.sp, textAlign = TextAlign.Center,)
    Text(
        text =" 6. Project Management - PRM362S",
        fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)
    Text(
        text ="Semester theory module",
        fontSize = 14.sp, textAlign = TextAlign.Center,)

    Text(
        text =" 7. Project - PRT362S",
        fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)
    Text(
        text ="Year-round practical module",
        fontSize = 14.sp, textAlign = TextAlign.Center,)
    Text(
        text =" 8. Project Presentation  - PRP362S",
        fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,)
    Text(
        text ="Year-round practical module",
        fontSize = 14.sp, textAlign = TextAlign.Center,)
}

@Composable
fun Alert(navController: NavController){
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
            Text(text = "Leaving now?")
        }
        Button(

            colors = mainButtonColor,
            onClick = {navController.navigate(route = Screen.Detail.route)},
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = "Back")
        }}


    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Exit", color = Color.White) },
            text = { Text("Are you leaving now?", color = Color.White) },
            confirmButton = {
                TextButton(
                    onClick = {navController.navigate(route = Screen.Module.route)

                    }
                ) {  Text("No", color = Color.White)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        exitProcess(0)
                    }
                ) { Text("Yes", color = Color.White)
                }
            },
            backgroundColor = colorResource(id = R.color.teal_200),
            contentColor = Color.White
        )
    }
}






