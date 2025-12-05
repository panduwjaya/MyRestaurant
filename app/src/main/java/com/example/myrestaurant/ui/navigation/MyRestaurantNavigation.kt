package com.example.myrestaurant.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myrestaurant.ui.screen.customer.CustomerScreen
import com.example.myrestaurant.ui.screen.detail.DetailScreen
import com.example.myrestaurant.ui.screen.home.HomeScreen
import com.example.myrestaurant.ui.screen.listorder.ListOrderScreen
import com.example.myrestaurant.ui.screen.order.InsertOrderScreen
import com.example.myrestaurant.ui.screen.splash.RestaurantSplashScreen

@Composable
fun MyRestaurantNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            RestaurantSplashScreen(navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onAddClick = {
                    navController.navigate(Screen.InsertOrder.route)
                },
                onRegistCustomer = {
                    navController.navigate(Screen.RegisterCustomer.route)
                }
            )
        }

        composable(Screen.RegisterCustomer.route) {
            CustomerScreen(
                onBackClick = {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Home.route){{ inclusive = true }}
                    }
                },
                onRegisterSuccess = {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Home.route){{ inclusive = true }}
                    }
                }
            )
        }

        composable(Screen.InsertOrder.route) {
            InsertOrderScreen(
                onBack = {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Home.route){{ inclusive = true }}
                    }
                },
                onOrder = {
                    navController.navigate(Screen.ListOrder.route)
                }
            )
        }

        composable(Screen.ListOrder.route) {
            ListOrderScreen(
                onBack = {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Home.route){{ inclusive = true }}
                    }
                },
                onAdd = {

                }
            )
        }

        composable(Screen.Detail.route) {
            DetailScreen(
                onBackClick = {

                },
                onCloseClick = {

                },
                id_list_order = 0
            )
        }
    }
}
