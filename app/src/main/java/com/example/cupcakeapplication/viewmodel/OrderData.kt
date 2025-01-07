package com.example.cupcakeapplication.viewmodel

data class OrderData(
    val quantity: Int = 0,
    val date: String = "",
    val price: Int = 0,
    val flavor: String = "",
    val dateList: MutableList<String> = mutableListOf()
)
