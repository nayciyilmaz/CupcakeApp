package com.example.cupcakeapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cupcakeapplication.data.sameDay
import com.example.cupcakeapplication.data.unitPrice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class OrderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderData())
    val uiState: StateFlow<OrderData> = _uiState.asStateFlow()

    fun subTotal(quantity: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                price = unitPrice * quantity,
                quantity = quantity
            )
        }
    }

    fun setFlavor(setFlavor: String) {
        _uiState.update { currentState ->
            currentState.copy(flavor = setFlavor)
        }
    }

    fun formatTotalPrice(): String {
        return if (_uiState.value.dateList.isNotEmpty() && _uiState.value.date == _uiState.value.dateList[0]) {
            //Aynı güne sipariş
            NumberFormat.getCurrencyInstance().format(_uiState.value.price + sameDay)
        } else {
            // Farklı güne sipariş
            NumberFormat.getCurrencyInstance().format(_uiState.value.price)
        }
    }

    fun resetOrder() {
        _uiState.update { currentState ->
            currentState.copy(
                quantity = 0,
                date = "",
                price = 0,
                flavor = ""
            )
        }
    }
}