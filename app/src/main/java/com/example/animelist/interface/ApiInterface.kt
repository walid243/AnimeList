package com.example.animelist.`interface`

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import com.example.animelist.model.Anime
import com.example.animelist.model.Data
import retrofit2.Response


interface ApiInterface {
    @GET("anime")
    suspend fun getAnimeList(): Response<Data>

}
