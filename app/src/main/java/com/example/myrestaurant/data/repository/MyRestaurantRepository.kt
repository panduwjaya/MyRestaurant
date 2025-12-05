package com.example.myrestaurant.data.repository

import com.example.myrestaurant.data.model.AddOrderResponse
import com.example.myrestaurant.data.model.AllOrdersResponse
import com.example.myrestaurant.data.model.AvailableCustomersResponse
import com.example.myrestaurant.data.model.AvailableTablesResponse
import com.example.myrestaurant.data.model.OrderDetailResponse
import com.example.myrestaurant.data.model.RegisterCustomerResponse
import com.example.myrestaurant.data.network.NetworkingService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.net.SocketTimeoutException
import javax.inject.Inject
import javax.inject.Singleton
import com.example.myrestaurant.util.Result

@Singleton
class MyRestaurantRepository @Inject constructor(
    private val networkingService: NetworkingService
){
    fun fetchRegisterCustomer(name: String, phone: String): Flow<Result<RegisterCustomerResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.postRegisterCustomers(name,phone)
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, RegisterCustomerResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)

    fun fetchAddOrders(customer_id: Int,table_id: Int,menu: String): Flow<Result<AddOrderResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.postAddOrders(customer_id,table_id,menu)
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, AddOrderResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)

    fun fetchAvaibleTables(): Flow<Result<AvailableTablesResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.getAvaibleTables()
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, AvailableTablesResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)

    fun fetchAvaibleCustomers(): Flow<Result<AvailableCustomersResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.getAvaibleCustomers()
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, AvailableCustomersResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)

    fun fetchOrderDetail(id: Int): Flow<Result<OrderDetailResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.getOrderDetail(id)
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, OrderDetailResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)

    fun fetchAllOrders(): Flow<Result<AllOrdersResponse>> = flow {
        emit(Result.Loading)
        try {
            val response = networkingService.getAllOrders()
            emit(Result.Success(response))
        } catch (e: SocketTimeoutException) {
            emit(Result.Error("Koneksi ke server gagal"))
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(json, AllOrdersResponse::class.java)
        } catch (e: Exception) {
            emit(Result.Error("Terjadi kesalahan: ${e.localizedMessage}"))
        }
    }.flowOn(Dispatchers.IO)
}