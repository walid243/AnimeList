package com.example.animelist.`interface`

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import com.example.animelist.model.Character
import retrofit2.http.Path


interface ApiInterface {
        //Aquí posem les operacions GET,POST, PUT i DELETE vistes abans
        @GET("characters")
        fun getCharacters(): Call<List<Character>>

        @GET("characters/{name}")
        fun getPlanet(@Path("name") name:String): Call<Character>

    companion object {
            private const val BASE_URL = "https://dragon-ball-super-api.herokuapp.com/api/"
            fun create(): ApiInterface {
                val client = OkHttpClient.Builder().build()
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                return retrofit.create(ApiInterface::class.java)
            }
        }

}
