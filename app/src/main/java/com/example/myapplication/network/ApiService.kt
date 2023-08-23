package com.example.jelajah.network


import com.example.jelajah.data.ResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getAllCountryData(): Call<List<ResponseItem>>
}