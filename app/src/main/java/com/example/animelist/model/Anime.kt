package com.example.animelist.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.Nullable

@Entity(tableName = "Anime")
@Parcelize
@Serializable
data class Anime(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @SerialName("mal_id")
    val malId: Int,
    @SerialName("episodes")
    val episodes: Int,
//    @SerialName("images")
//    val images: Images,
    @SerialName("status")
    val status: String,
    @SerialName("synopsis")
    val synopsis: String,
    @SerialName("title")
    val title: String,
    @SerialName("title_english")
    val titleEnglish: String,
    @SerialName("title_japanese")
    val titleJapanese: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String,
    @SerialName("year")
    val year: Int,

    var isFav: Boolean = false
): android.os.Parcelable