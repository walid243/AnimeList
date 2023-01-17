package com.example.animelist.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.animelist.`interface`.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.animelist.model.Anime
import com.example.animelist.model.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    suspend fun fetchData(): Data? {
        println("fetching data")
        val response = apiInterface.getAnimeList()
        return if(response.isSuccessful){
//            println("Response: ${response.body()?.data?.size}")
            response.body()!!
        } else{
            Log.e("Error :", response.message())
            null
        }
    }

}
