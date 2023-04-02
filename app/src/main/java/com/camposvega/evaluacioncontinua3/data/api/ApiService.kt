package com.camposvega.evaluacioncontinua3.data.api

import com.camposvega.evaluacioncontinua3.data.DogResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("breeds/image/random/100")
    fun getDogs() : Call<DogResponse>
}