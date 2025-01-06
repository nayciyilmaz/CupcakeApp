package com.example.cupcakeapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcakeapplication.screens.StartOrderScreen

@Composable
fun CupcakeNavigation() {
    val navController = rememberNavController()

    NavHost(navController =  navController, startDestination = CupcakeScreens.StartOrderScreen.route) {
        composable(CupcakeScreens.StartOrderScreen.route){
            StartOrderScreen(navController = navController)
        }
        composable(CupcakeScreens.SelectFlavorScreen.route){

        }
        composable(CupcakeScreens.SelectDateScreen.route){

        }
        composable(CupcakeScreens.SummaryScreen.route){

        }
    }
}