package com.example.myrestaurant.ui.screen.home

import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onAddClick: () -> Unit,
    onRegistCustomer: () -> Unit
) {

    HomeScreenContent(
        onAddClick = onAddClick,
        onCustomerRegisterClick = onRegistCustomer
    )
}
