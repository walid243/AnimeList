package com.example.animelist.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link(
    @SerialName("active")
    val active: Boolean,
    @SerialName("label")
    val label: String,
    @SerialName("url")
    val url: String
)