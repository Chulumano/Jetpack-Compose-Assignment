package com.example.jetpackcomposeassignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeassignment2.ui.theme.JetpackComposeAssignment2Theme
import androidx.compose.runtime.remember as remember
//Author : Chulumanco Buhle Nkwindana
//219390983
//13 April 2022
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAssignment2Theme() {


                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                )
                {
                    MyWelcomeText()
                    AlertDialog()
                }

            }
        }}

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
    fun AlertDialog(){
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
                Text(text = "info")
                Icon(imageVector = Icons.Outlined.Info,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 5.dp))
            } }


        if (openDialog.value) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false },
                title = { Text(text = "Information", color = Color.White) },
                text = { Text("Hello! Jetpack Compose has made coding android apps so much easier than before." +
                        "It's less time consuming and quicker, you should also try it.", color = Color.White) },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) {  Text("Okay", color = Color.White)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog.value = false
                        }
                    ) { Text("Dismiss", color = Color.White)
                    }
                },
                backgroundColor = colorResource(id = R.color.teal_200),
                contentColor = Color.White
            )
        }
    }
}
