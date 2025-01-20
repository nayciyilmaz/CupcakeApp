package com.example.cupcakeapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcakeapplication.screens.SelectDateScreen
import com.example.cupcakeapplication.screens.SelectFlavorScreen
import com.example.cupcakeapplication.screens.StartOrderScreen
import com.example.cupcakeapplication.screens.SummaryScreen
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
            SelectDateScreen(
                navController = navController,
                totalPrice = { orderViewModel.formatTotalPrice() },
                canNavigateBack = navController.previousBackStackEntry != null,
                resetOrder = { orderViewModel.resetOrder() },
                currentDateList = { orderViewModel.currentDateList() },
                setDate = { orderViewModel.setDate(it) },
                date = uiState.date
            )
        }
        composable(CupcakeScreens.SummaryScreen.route) {
            SummaryScreen(
                quantity = uiState.quantity,
                flavor = uiState.flavor,
                pieceCupcake = { orderViewModel.pieceCupcake() },
                currentDate = uiState.date,
                totalPrice = { orderViewModel.formatTotalPrice() },
                navController = navController,
                resetOrder = { orderViewModel.resetOrder() },
                canNavigateBack = navController.previousBackStackEntry != null
            )
        }
    }
}