package com.example.animelist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AnimeEntity")
data class AnimeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val malId: Int,
    val episodes: Int,
    val status: String,
    val synopsis: String,
    val title: String,
    val type: String,
    val url: String,
    val year: Int,
    var isFav: Boolean = false
)