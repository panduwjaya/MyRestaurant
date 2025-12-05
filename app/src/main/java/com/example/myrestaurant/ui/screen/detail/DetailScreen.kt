package com.example.myrestaurant.ui.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen(
    onBackClick: () -> Unit,
    onCloseClick: () -> Unit,
    id_list_order: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {

    LaunchedEffect(id_list_order) {
        viewModel.loadDetailOrder(id_list_order)
    }

    DetailScreenContent(
        numberOrder = viewModel.id.toString() ?: "",
        name = viewModel.customer_name ?: "",
        tableNumber = viewModel.table_id.toString() ?: "",
        foodOrder = viewModel.menu ?: "",
        onBackClick = onBackClick,
        onCloseClick = onCloseClick
    )
}
