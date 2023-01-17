package com.example.animelist.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class To(
    @SerialName("day")
    val day: Int,
    @SerialName("month")
    val month: Int,
    @SerialName("year")
    val year: Int
)