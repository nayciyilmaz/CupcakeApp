package com.example.cupcakeapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cupcakeapplication.data.sameDay
import com.example.cupcakeapplication.data.unitPrice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class OrderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderData())
    val uiState: StateFlow<OrderData> = _uiState.asStateFlow()

    fun setFlavor(setFlavor: String) {
        _uiState.update { currentState ->
            currentState.copy(flavor = setFlavor)
        }
    }

    fun setDate(setDate: String) {
        _uiState.update { currentState ->
            currentState.copy(date = setDate)
        }
    }

    fun subTotal(quantity: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                price = unitPrice * quantity,
                quantity = quantity
            )
        }
    }

    fun pieceCupcake(): Boolean = uiState.value.quantity <= 1

    fun formatTotalPrice(): String {
        return if (_uiState.value.dateList.isNotEmpty() && _uiState.value.date == _uiState.value.dateList[0]) {
            //Aynı güne sipariş
            NumberFormat.getCurrencyInstance().format(_uiState.value.price + sameDay)
        } else {
            // Farklı güne sipariş
            NumberFormat.getCurrencyInstance().format(_uiState.value.price)
        }
    }

    fun currentDateList(): MutableList<String> {
        _uiState.value.dateList.clear()
        val calendar = Calendar.getInstance() // Güncel tarih
        val formatter = SimpleDateFormat(
            "dd MMMM yyyy EEEE", Locale.getDefault() // 09 Ocak 2025 Perşembe
        )
        repeat(4) {
            _uiState.value.dateList.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }
        return _uiState.value.dateList
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