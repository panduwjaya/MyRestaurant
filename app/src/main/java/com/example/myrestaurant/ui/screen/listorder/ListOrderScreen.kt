package com.example.myrestaurant.ui.screen.listorder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

@Composable
fun ListOrderScreen(
    onBack: () -> Unit,
    onAdd: () -> Unit,
) {
    // Anda bisa ganti dengan state dari ViewModel
    val orders = remember {
        mutableStateListOf("No. Pesanan: 1", "No. Pesanan: 2", "No. Pesanan: 3")
    }

    ListOrderScreenContent(
        orders = orders,
        onBackClick = onBack,
        onAddClick = {
            orders.add("No. Pesanan: ${orders.size + 1}")
        },
        onDeleteClick = { order ->
            orders.remove(order)
        }
    )
}
