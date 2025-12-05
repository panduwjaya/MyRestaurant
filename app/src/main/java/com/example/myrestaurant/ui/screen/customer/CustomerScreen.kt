package com.example.myrestaurant.ui.screen.customer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CustomerScreen(
    onBackClick: () -> Unit,
    onRegisterSuccess: () -> Unit,
    viewModel: RegisterCustomerViewModel = hiltViewModel()
) {
    val registerResult by viewModel.registerResult.collectAsState()
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    CustomerScreenContent(
        name = name,
        phone = phone,
        onNameChange = { name = it },
        onPhoneChange = { phone = it },
        onBackClick = onBackClick,
        onRegisterClick = {
            viewModel.registerCustomer(name, phone)
        },
        registerCustomerResult = registerResult,
        onRegisterCustomerSuccess = onRegisterSuccess
    )
}
