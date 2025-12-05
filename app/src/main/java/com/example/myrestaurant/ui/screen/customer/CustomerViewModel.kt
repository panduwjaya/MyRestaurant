package com.example.myrestaurant.ui.screen.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrestaurant.data.model.RegisterCustomerResponse
import com.example.myrestaurant.data.repository.MyRestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.myrestaurant.util.Result

@HiltViewModel
class RegisterCustomerViewModel @Inject constructor(
    private val repository: MyRestaurantRepository
) : ViewModel() {

    private val _registerResult = MutableStateFlow<Result<RegisterCustomerResponse>?>(null)
    val registerResult: StateFlow<Result<RegisterCustomerResponse>?> = _registerResult

    fun registerCustomer(name: String,phone: String) {
        viewModelScope.launch {
            repository.fetchRegisterCustomer(name,phone)
                .collect { result ->
                    _registerResult.value = result
                }
        }
    }
}