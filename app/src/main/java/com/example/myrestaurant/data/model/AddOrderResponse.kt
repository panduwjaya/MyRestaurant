package com.example.myrestaurant.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AddOrderResponse(
    val id: Int,
    val customer_id: Int,
    val table_id: Int,
    val menu: String,
    val created_at: String
)