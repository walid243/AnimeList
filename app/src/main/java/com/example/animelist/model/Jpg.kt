package com.example.animelist.model


import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Parcelize
@Serializable
data class Jpg(
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("large_image_url")
    val largeImageUrl: String,
    @SerialName("small_image_url")
    val smallImageUrl: String
): android.os.Parcelable