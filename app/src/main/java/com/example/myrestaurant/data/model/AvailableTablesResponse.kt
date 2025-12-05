package com.example.myrestaurant.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AvailableTablesResponse(
    val available_tables: List<TableData>
)

@Serializable
data class TableData(
    val id: Int,
    val status: String
)
