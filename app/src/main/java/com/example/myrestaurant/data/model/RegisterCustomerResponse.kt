package com.example.myrestaurant.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RegisterCustomerResponse(
    val id: Int,
    val name: String,
    val phone: String,
    val created_at: String
)