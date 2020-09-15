package com.example.themoviesdb.data.models

import com.example.themoviesdb.IMAGE_BASE_URL
import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("popularity") var popularity: Float,
    @SerializedName("known_for_department") var knownGenre: String,
    @SerializedName("gender") var gender: Int,
    @SerializedName("id") var id: Int,
    @SerializedName("profile_path")private var image: String,
    @SerializedName("name") var name: String
) {
    fun getImageUrl(): String {
        return IMAGE_BASE_URL + image
    }
}