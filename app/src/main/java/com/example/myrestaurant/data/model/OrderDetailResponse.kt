package com.example.myrestaurant.data.model

import kotlinx.serialization.Serializable

@Serializable
data class OrderDetailResponse(
    val id: Int,
    val customer_name: String,
    val table_id: Int,
    val menu: String,
    val created_at: String
)