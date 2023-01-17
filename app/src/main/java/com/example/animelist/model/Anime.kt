package com.example.animelist.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Anime(
    @SerialName("mal_id")
    val id: Int,
//    @SerialName("url")
//    val url: String,
//    @SerialName("image_url")
//    val imageUrl: String,
//    @SerialName("title")
//    val title: String,
//    @SerialName("type")
//    val type: String,
//    @SerialName("source")
//    val source: String,
//    @SerialName("episodes")
//    val episodes: String,
//    @SerialName("status")
//    val status: String,
//    @SerialName("duration")
//    val duration: String
)