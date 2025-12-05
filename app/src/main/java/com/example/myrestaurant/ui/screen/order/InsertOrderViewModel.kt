package com.example.myrestaurant.ui.screen.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrestaurant.data.model.AddOrderResponse
import com.example.myrestaurant.data.repository.MyRestaurantRepository
import com.example.myrestaurant.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertOrderViewModel @Inject constructor(
    private val repository: MyRestaurantRepository
) : ViewModel() {

    private val _insertResult = MutableStateFlow<Result<AddOrderResponse>?>(null)
    val insertResult: StateFlow<Result<AddOrderResponse>?> = _insertResult

    fun insertOrder(customer_id: Int,table_id: Int,menu: String) {
        viewModelScope.launch {
            repository.fetchAddOrders(customer_id,table_id,menu)
                .collect { result ->
                    _insertResult.value = result
                }
        }
    }
}