package com.example.cupcakeapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cupcakeapplication.R
import com.example.cupcakeapplication.components.EditTopAppBar
import com.example.cupcakeapplication.data.DataSource
import com.example.cupcakeapplication.navigation.CupcakeScreens

@Composable
fun SelectFlavorScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    canNavigateBack: Boolean,
    flavor: String,
    resetOrder: () -> Unit,
    setFlavor: (String) -> Unit,
    totalPrice: () -> String
) {
    var selectedFlavor by rememberSaveable { mutableStateOf(flavor) }
    val flavorString = DataSource.flavors.map { stringResource(id = it) }

    Scaffold(
        topBar = {
            EditTopAppBar(
                title = stringResource(R.string.choose_flavor),
                navigateBack = canNavigateBack,
                navigateIcon = {
                    navController.popBackStack()
                    resetOrder()
                }
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
                modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                flavorString.forEach { flavors ->
                    Row(
                        modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (selectedFlavor == flavors),
                                onClick = {
                                    setFlavor(flavors)
                                    selectedFlavor = flavors
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (selectedFlavor == flavors),
                            onClick = {
                                setFlavor(flavors)
                                selectedFlavor = flavors
                            }
                        )
                        Text(
                            text = flavors
                        )
                    }
                }
            }
            HorizontalDivider(
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            Text(
                text = stringResource(R.string.subtotal, totalPrice()),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(modifier = modifier.weight(1f))

            Row(
                modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate(CupcakeScreens.StartOrderScreen.route)
                        resetOrder()
                    },
                    modifier = modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.cancel),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                Spacer(modifier = modifier.weight(0.1f))

                Button(
                    onClick = {
                        navController.navigate(CupcakeScreens.SelectDateScreen.route)
                    },
                    modifier = modifier.weight(1f),
                    enabled = selectedFlavor.isNotEmpty()
                ) {
                    Text(
                        text = stringResource(R.string.next),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}