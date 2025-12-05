package com.example.myrestaurant.dependency

import com.example.myrestaurant.data.network.NetworkingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL_MAIN = "http://10.0.2.2:3000/"

    // 1. PROVIDE OKHTTP
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    // 2. PROVIDE RETROFIT
    @Provides
    @Singleton
    fun provideMainApiRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL_MAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    // 3. PROVIDE NETWORKING SERVICE
    @Provides
    @Singleton
    fun provideNetworkingService(retrofit: Retrofit): NetworkingService =
        retrofit.create(NetworkingService::class.java)
}
