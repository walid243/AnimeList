package com.example.animelist.dao

import androidx.room.*
import com.example.animelist.model.AnimeEntity


@Dao
interface AnimeDAO {
    @Query("SELECT * FROM AnimeEntity")
    fun getAll(): List<AnimeEntity>
    @Query("SELECT * FROM AnimeEntity WHERE title = :title")
    fun getAnime(title: String): MutableList<AnimeEntity>
    @Insert
    fun addAnime(anime: AnimeEntity)
    @Delete
    fun deleteAnime(anime: AnimeEntity)
    @Update
    fun updateAnime(anime: AnimeEntity)

}