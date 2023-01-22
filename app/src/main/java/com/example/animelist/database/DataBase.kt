package com.example.animelist.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.animelist.dao.AnimeDAO
import com.example.animelist.model.Anime

@Database(entities = [Anime::class], version = 1)
abstract class AnimeDataBase: RoomDatabase() {
    abstract fun animeDao(): AnimeDAO
}
