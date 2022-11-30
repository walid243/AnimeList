package com.example.animelist.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    @SerialName("id")
    val id: Int,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("originplanet")
    val originplanet: String,
    @SerialName("role")
    val role: String,
    @SerialName("specie")
    val specie: String,
    @SerialName("status")
    val status: String,
    @SerialName("transform")
    val transform: String,
    @SerialName("universe")
    val universe: String
)