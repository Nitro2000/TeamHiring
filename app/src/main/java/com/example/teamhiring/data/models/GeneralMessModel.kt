package com.example.teamhiring.data.models

import com.google.gson.annotations.SerializedName

data class GeneralMessModel(
    @SerializedName("status") val status: Int,
    @SerializedName("message") val message: String
)