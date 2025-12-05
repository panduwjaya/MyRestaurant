package com.example.myrestaurant.ui.screen.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrestaurant.data.repository.MyRestaurantRepository
import com.example.myrestaurant.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: MyRestaurantRepository
): ViewModel() {
    var id by mutableStateOf(0)
        private set

    var customer_name by mutableStateOf("")
        private set

    var table_id by mutableStateOf(0)
        private set

    var menu by mutableStateOf("")
        private set

    var created_at by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set


    fun loadDetailOrder(id_list_order: Int) {
        viewModelScope.launch {
            repository.fetchOrderDetail(id_list_order).collect { result ->
                when (result) {
                    is Result.Loading -> {
                        isLoading = true
                        errorMessage = null
                    }
                    is Result.Success -> {
                        val data = result.data
                        id = data.id
                        customer_name = data.customer_name
                        table_id = data.table_id
                        menu = data.menu
                        created_at = data.created_at
                    }
                    is Result.Error -> {
                        isLoading = false
                        errorMessage = result.error
                    }
                }
            }
        }
    }
}