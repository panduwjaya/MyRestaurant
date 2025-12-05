package com.example.myrestaurant.data.network

import com.example.myrestaurant.data.model.AddOrderResponse
import com.example.myrestaurant.data.model.AllOrdersResponse
import com.example.myrestaurant.data.model.AvailableCustomersResponse
import com.example.myrestaurant.data.model.AvailableTablesResponse
import com.example.myrestaurant.data.model.DeleteOrderResponse
import com.example.myrestaurant.data.model.OrderDetailResponse
import com.example.myrestaurant.data.model.RegisterCustomerResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.Query

interface NetworkingService {

    @FormUrlEncoded
    @POST("customers")
    suspend fun postRegisterCustomers(
        @Field("name") name: String,
        @Field("phone") phone: String
    ): RegisterCustomerResponse

    @FormUrlEncoded
    @POST("orders")
    suspend fun postAddOrders(
        @Field("customer_id") customer_id: Int,
        @Field("table_id") table_id: Int,
        @Field("menu") menu: String
    ): AddOrderResponse

    @GET("tables/available")
    suspend fun getAvaibleTables(): AvailableTablesResponse

    @GET("customers/available")
    suspend fun getAvaibleCustomers(): AvailableCustomersResponse

    @GET("order")
    suspend fun getOrderDetail(
        @Query("id") id: Int
    ): OrderDetailResponse

    @GET("orders")
    suspend fun getAllOrders(): AllOrdersResponse

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "orders/", hasBody = true)
    suspend fun deleteOrder(
        @Field("orderId") orderId: Int
    ): DeleteOrderResponse
}