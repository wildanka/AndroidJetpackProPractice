package com.wildanka.moviecatalogue.util

import com.wildanka.moviecatalogue.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{
    private val httpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }

}