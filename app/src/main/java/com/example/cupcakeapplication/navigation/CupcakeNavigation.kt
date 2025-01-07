package com.example.cupcakeapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcakeapplication.screens.SelectFlavorScreen
import com.example.cupcakeapplication.screens.StartOrderScreen
import com.example.cupcakeapplication.viewmodel.OrderViewModel

@Composable
fun CupcakeNavigation() {
    val navController = rememberNavController()
    val orderViewModel: OrderViewModel = viewModel()
    val uiState by orderViewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = CupcakeScreens.StartOrderScreen.route
    ) {
        composable(CupcakeScreens.StartOrderScreen.route) {
            StartOrderScreen(
                navController = navController,
                subTotal = { orderViewModel.subTotal(it) }
            )
        }
        composable(CupcakeScreens.SelectFlavorScreen.route) {
            SelectFlavorScreen(
                navController = navController,
                flavor = uiState.flavor,
                canNavigateBack = navController.previousBackStackEntry != null,
                resetOrder = { orderViewModel.resetOrder() },
                setFlavor = { orderViewModel.setFlavor(it) },
                totalPrice = { orderViewModel.formatTotalPrice() }
            )
        }
        composable(CupcakeScreens.SelectDateScreen.route) {

        }
        composable(CupcakeScreens.SummaryScreen.route) {

        }
    }
}