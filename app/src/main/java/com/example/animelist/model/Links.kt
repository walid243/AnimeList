package com.example.animelist.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("first")
    val first: String,
    @SerialName("last")
    val last: String,
    @SerialName("next")
    val next: String,
    @SerialName("prev")
    val prev: Any
)