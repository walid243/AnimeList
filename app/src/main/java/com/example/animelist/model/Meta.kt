package com.example.animelist.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("current_page")
    val currentPage: Int,
    @SerialName("from")
    val from: Int,
    @SerialName("last_page")
    val lastPage: Int,
    @SerialName("links")
    val links: List<Link>,
    @SerialName("path")
    val path: String,
    @SerialName("per_page")
    val perPage: Int,
    @SerialName("to")
    val to: Int,
    @SerialName("total")
    val total: Int
)