package com.example.teamhiring.data.models

import com.google.gson.annotations.SerializedName

data class EmpRegisterBody(
    @SerializedName("name")
    val empName: String,

    @SerializedName("email")
    val empEmail: String,

    @SerializedName("mobile_no")
    val empMobile: String,

    @SerializedName("pass")
    val empPassword: String
)