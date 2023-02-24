package com.example.teamhiring.data.models

import com.google.gson.annotations.SerializedName

data class LoginData (
    @SerializedName("status") val loginStatus: String?,
    @SerializedName("message") val loginMessage: String?,
    @SerializedName("data")
    val empData: List<LoginEmpData?>? = listOf(),
    )

data class LoginEmpData(
    @SerializedName("id")
    val empId: String? = "",
    @SerializedName("c_name")
    val empName: String? = "",
    @SerializedName("c_email")
    val empEmail: String? = "",
    @SerializedName("c_contact")
    val empContact: String? = "",
    @SerializedName("created_at")
    val empCreatedAt: String? = "",
    @SerializedName("log_in_time")
    val empLoginTime: String? = "",
    @SerializedName("c_pas")
    val empPassword: String? = ""
)
