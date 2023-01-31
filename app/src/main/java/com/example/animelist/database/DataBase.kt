package com.example.animelist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.animelist.dao.AnimeDAO
import com.example.animelist.model.AnimeEntity

@Database(entities = [AnimeEntity::class], version = 1)
abstract class AnimeDataBase: RoomDatabase() {
    abstract fun animeDao(): AnimeDAO

    companion object {
        @Volatile
        private var INSTANCE: AnimeDataBase? = null

        fun getDatabase(context: Context): AnimeDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimeDataBase::class.java,
                    "AnimeDataBase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
