package com.example.androidbasics

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private val retrofitService = Retrofit.Builder()
        .baseUrl("https://reqres.in/api")
        .addConverterFactory(GsonConverterFactory.create())
        .build()



}