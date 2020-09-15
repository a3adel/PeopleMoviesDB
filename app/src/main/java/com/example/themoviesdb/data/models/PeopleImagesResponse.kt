package com.example.themoviesdb.data.models

import com.google.gson.annotations.SerializedName

data class PeopleImagesResponse(@SerializedName("profiles")var profiles:ArrayList<PersonProfile>)