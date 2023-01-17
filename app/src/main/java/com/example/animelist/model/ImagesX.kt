package com.example.animelist.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesX(
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("large_image_url")
    val largeImageUrl: String,
    @SerialName("maximum_image_url")
    val maximumImageUrl: String,
    @SerialName("medium_image_url")
    val mediumImageUrl: String,
    @SerialName("small_image_url")
    val smallImageUrl: String
)