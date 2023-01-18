package com.example.animelist.`interface`

import retrofit2.http.GET
import com.example.animelist.model.Data
import retrofit2.Response


interface ApiInterface {
    @GET("anime")
    suspend fun getAnimeList(): Response<Data>

}
