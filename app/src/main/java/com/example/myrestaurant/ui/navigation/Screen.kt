package com.example.myrestaurant.ui.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash")
    object Home: Screen("home")
    object RegisterCustomer: Screen("register_customer")
    object ListOrder: Screen("list_order")
    object Detail: Screen("detail_order")
    object InsertOrder: Screen("insert_order")
}