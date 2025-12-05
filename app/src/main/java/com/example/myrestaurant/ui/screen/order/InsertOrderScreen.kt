package com.example.myrestaurant.ui.screen.order

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun InsertOrderScreen(
    onBack: () -> Unit,
    onOrder: () -> Unit
) {
    // State contoh (bisa diganti ViewModel)
    var selectedCustomer by remember { mutableStateOf("") }
    var selectedTable by remember { mutableStateOf("") }
    var menu by remember { mutableStateOf("") }

    InsertOrderScreenContent(
        selectedCustomer = selectedCustomer,
        selectedTable = selectedTable,
        menu = menu,
        onCustomerClick = { /* open customer dropdown */ },
        onTableClick = { /* open table dropdown */ },
        onMenuChange = {menu = it},
        onBack = onBack,
        onOrderClick = onOrder
    )
}
