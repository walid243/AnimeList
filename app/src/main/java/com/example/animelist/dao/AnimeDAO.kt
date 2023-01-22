package com.example.animelist.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import com.example.animelist.model.Anime
import com.example.animelist.model.Genre
import com.example.animelist.model.Images
import kotlinx.serialization.SerialName


@Dao
interface AnimeDAO {
    @Query("SELECT * FROM Anime")
    fun getAll(): List<Anime>
    @Insert
    fun addAnime(anime: Anime)
    @Delete
    fun deleteAnime(anime: Anime)
    @Update
    fun updateAnime(anime: Anime)

}