package com.example.animelist.model


import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Entity(tableName = "Images")
@Parcelize
@Serializable
data class Images(
    @SerialName("jpg")
    val jpg: Jpg,
    @SerialName("webp")
    val webp: Webp
): android.os.Parcelable