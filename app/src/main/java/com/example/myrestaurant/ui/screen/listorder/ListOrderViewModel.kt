package com.example.myrestaurant.ui.screen.listorder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrestaurant.data.repository.MyRestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.myrestaurant.util.Result

@HiltViewModel
class ListOrderViewModel @Inject constructor(
    private val repository: MyRestaurantRepository
): ViewModel() {

    var email by mutableStateOf("-")
        private set
    var name by mutableStateOf("-")
        private set
    var gender by mutableStateOf("-")
        private set
    var relationship by mutableStateOf("-")
        private set
    var age by mutableStateOf("-")
        private set
    var photourl by mutableStateOf("-")
        private set

    var isLoading by mutableStateOf(false)
        private set
    var errorMessage by mutableStateOf<String?>(null)
        private set



    init {
        loadListOrder()
    }

    fun loadListOrder() {
        viewModelScope.launch {
            repository.fetchAllOrders().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        isLoading = true
                        errorMessage = null
                    }
                    is Result.Success -> {

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