package com.example.cupcakeapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cupcakeapplication.R
import com.example.cupcakeapplication.components.EditTopAppBar
import com.example.cupcakeapplication.navigation.CupcakeScreens

@Composable
fun StartOrderScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = {
            EditTopAppBar(
                title = stringResource(R.string.cupcake),
                navigateBack = false
            )
        }
    ) { innerPadding ->
        Column(
            modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.cupcake),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.order_cupcakes),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = modifier.padding(top = 16.dp)
                )
            }

            Spacer(modifier = modifier.weight(1f))

            Column(modifier.fillMaxWidth()) {
                Button(
                    onClick = { navController.navigate(CupcakeScreens.SelectFlavorScreen.route) },
                    shape = RoundedCornerShape(32.dp),
                    modifier = modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(
                        text = stringResource(R.string.one_cupcake),
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { navController.navigate(CupcakeScreens.SelectFlavorScreen.route) },
                    shape = RoundedCornerShape(32.dp),
                    modifier = modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(
                        text = stringResource(R.string.six_cupcakes),
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    onClick = { navController.navigate(CupcakeScreens.SelectFlavorScreen.route) },
                    shape = RoundedCornerShape(32.dp),
                    modifier = modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(
                        text = stringResource(R.string.twelve_cupcakes),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}