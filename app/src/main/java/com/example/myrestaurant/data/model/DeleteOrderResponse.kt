package com.example.myrestaurant.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DeleteOrderResponse(
    val success: Boolean,
    val message: String
)