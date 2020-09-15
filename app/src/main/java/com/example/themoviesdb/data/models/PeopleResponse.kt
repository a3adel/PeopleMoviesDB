package com.example.themoviesdb.data.models

import com.google.gson.annotations.SerializedName

data class PeopleResponse(
    @SerializedName("page") var page: Int,
    @SerializedName("total_results") var totalResults: Int,
    @SerializedName("total_pages") var totalPages: Int,
    @SerializedName("results") var people: ArrayList<Person>
)