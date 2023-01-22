package com.example.animelist.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("data")
    val `data`: List<Anime>,
    @SerialName("links")
    val links: Links,
    @SerialName("meta")
    val meta: Meta,
    @SerialName("pagination")
    val pagination: Pagination
)