package com.example.myrestaurant.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AvailableCustomersResponse(
    val available_customers: List<CustomerItem>
)

@Serializable
data class CustomerItem(
    val id: Int,
    val name: String,
    val phone: String,
    val created_at: String
)

