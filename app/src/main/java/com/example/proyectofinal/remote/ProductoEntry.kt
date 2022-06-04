package com.example.proyectofinal.remote

import com.google.gson.annotations.SerializedName

data class ProductoEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("rating")
    val rating: ratingEntry2
)

data class ratingEntry2(
    @SerializedName("rate")
    val rate: Double,
)