package com.example.myrestaurant.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AllOrdersResponse(
    val orders: List<OrderItem>
)

@Serializable
data class OrderItem(
    val order_id: Int,
    val customer_name: String,
    val table_id: Int,
    val menu: String,
    val created_at: String
)

