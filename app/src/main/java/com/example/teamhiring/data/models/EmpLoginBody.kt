package com.example.teamhiring.data.models

import com.google.gson.annotations.SerializedName

data class EmpLoginBody(
    @SerializedName("email")
    val email: String,

    @SerializedName("pass")
    val password: String
)
