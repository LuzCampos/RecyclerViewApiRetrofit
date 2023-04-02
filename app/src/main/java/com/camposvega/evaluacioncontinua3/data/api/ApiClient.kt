package com.camposvega.evaluacioncontinua3.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    object ApiClient {
        private const val BASE_URL = "https://dog.ceo/api/"
        private var retrofit: Retrofit? = null
        val client: Retrofit?
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return retrofit
            }
        val apiService: ApiService
            get() = client!!.create(ApiService::class.java)
    }
}