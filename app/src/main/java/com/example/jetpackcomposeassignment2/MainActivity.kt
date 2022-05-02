package com.example.jetpackcomposeassignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import com.example.jetpackcomposeassignment2.ui.theme.JetpackComposeAssignment2Theme


object NavRoute{
    val SCREEN_A = "ScreenA"
    val SCREEN_B = "ScreenB"}

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
fun MyNavHost(navHostController: NavHostController){
    NavHost(
        navController=navHostController,
        startDestination = NavRoute.SCREEN_A
    ){

    }
    composable(NavRoute.SCREEN_A, {
        ScreenA{
            navHostController.navigate(NavRoute.SCREEN_B)
        }
    })

        composable(NavRoute.SCREEN_B){
            ScreenB{
                navHostController.navigate(NavRoute.SCREEN_A)
            }
        }
    }

}





