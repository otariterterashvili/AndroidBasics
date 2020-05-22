package com.example.androidbasics

import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object DataLoader {

    private val retrofitService = Retrofit.Builder()
        .baseUrl("http://newsapi.org/v2/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    private  var apiService = retrofitService.create<ApiService>(ApiService::class.java)

    fun getRequest(mainCallBack: MainCallBack){
        val call = apiService.getRequest("top-headlines")
        call.enqueue(callBack(mainCallBack))
    }

    private fun callBack(mainCallBack: MainCallBack) = object :Callback<String>{
        override fun onFailure(call: Call<String>, t: Throwable) {
            mainCallBack.onFailure(t.message.toString())
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            mainCallBack.onSuccess(response.body().toString())
        }

    }

}

interface ApiService{
    @GET("{path}?country=us&category=business&apiKey=152053eef9c941e094f776c1d37d4553")
    fun getRequest(@Path("path") path: String): Call<String>
}