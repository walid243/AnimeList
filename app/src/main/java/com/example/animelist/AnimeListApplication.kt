package com.example.animelist

import android.app.Application
import androidx.room.Room
import com.example.animelist.database.AnimeDataBase

class AnimeListApplication: Application() {
    companion object {
        lateinit var animeDataBase: AnimeDataBase
    }
    override fun onCreate() {
        super.onCreate()
        animeDataBase = Room.databaseBuilder(this,
            AnimeDataBase::class.java,
            "AnimeDataBase").build()
    }
}
