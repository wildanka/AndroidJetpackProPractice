package com.wildanka.moviecatalogue.util

import com.wildanka.moviecatalogue.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{
    private val interceptor = HttpLoggingInterceptor() //logging interceptor
    private val httpClient = OkHttpClient.Builder()
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        return createService(serviceClass, null)
    }

    private fun <S> createService(serviceClass: Class<S>, authToken: String?): S {
        //since we don't use authToken headers for TSDB API
        val client = httpClient.build()
        val retrofit = builder.client(client).build()
        return retrofit.create(serviceClass)
    }


}