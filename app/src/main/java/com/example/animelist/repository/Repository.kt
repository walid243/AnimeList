package com.example.animelist.repository

import android.util.Log
import com.example.animelist.`interface`.ApiInterface
import com.example.animelist.model.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    private val BASE_URL = "https://api.jikan.moe/v4/"
    private val apiInterface: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    suspend fun fetchData(url:String): Data? {
        println("fetching data")
        val finalUrl = BASE_URL+ url
        val response = apiInterface.getAnimeList()
        return if(response.isSuccessful){
            println("fetch done")
            println("Response: ${response.body()?.data?.size}")
            response.body()!!
        } else{
            Log.e("Error :", response.message())
            null
        }
    }

}
