package com.example.themoviesdb.data.models

import com.example.themoviesdb.IMAGE_BASE_URL
import com.google.gson.annotations.SerializedName

data class PersonProfile(@SerializedName("file_path") private var path: String) {
    fun getImage(): String {
        return IMAGE_BASE_URL + path
    }

}
