package com.example.animelist.repository

import android.util.Log
import com.example.animelist.AnimeListApplication
import com.example.animelist.`interface`.ApiInterface
import com.example.animelist.model.Anime
import kotlinx.coroutines.Dispatchers
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

    suspend fun fetchData(): List<Anime>? {
        val response = apiInterface.getAnimeList()
        return if(response.isSuccessful){
            println("images: ${response.body()!!.data[0]} <----- 31")
            response.body()!!.data
        } else{
            println("fetch failed <----- 31")
            Log.e("Error :", response.message())
            null
        }
    }

    suspend fun importFavData(): MutableList<Anime> {
        val favList = mutableListOf<Anime>()
        withContext(Dispatchers.IO) {
            AnimeListApplication.animeDataBase.animeDao().getAll().forEach {
                favList.add(
                    Anime(
                        malId = it.malId,
                        title = it.title,
                        synopsis = it.synopsis,
                        type = it.type,
                        episodes = it.episodes,
                        isFav = it.isFav
                    )
                )
            }
        }
        return favList
    }
}
