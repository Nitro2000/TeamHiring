package com.example.teamhiring.data.models.recruiter


import com.google.gson.annotations.SerializedName


data class RecruiterEmpData(
    @SerializedName("age") val age: String? = "",
    @SerializedName("c_contact") val cContact: String? = "",
    @SerializedName("c_email") val cEmail: String? = "",
    @SerializedName("c_name") val cName: String? = "",
    @SerializedName("c_pas") val cPas: String? = "",
    @SerializedName("created_at") val createdAt: String? = "",
    @SerializedName("DateDiff") val dateDiff: String? = "",
    @SerializedName("designation") val designation: String? = "",
    @SerializedName("eTYpe") val eTYpe: String? = "",
    @SerializedName("eng") val eng: String? = "",
    @SerializedName("english") val english: String? = "",
    @SerializedName("experience") val experience: String? = "",
    @SerializedName("gender") val gender: String? = "",
    @SerializedName("highestQual") val highestQual: String? = "",
    @SerializedName("id") val id: String? = "",
    @SerializedName("log_in_time") val logInTime: String? = "",
    @SerializedName("p_e_type") val pEType: String? = "",
    @SerializedName("p_job_roles") val pJobRoles: String? = "",
    @SerializedName("resume") val resume: String? = "",
    @SerializedName("skills_old") val skillsOld: String? = "",
    @SerializedName("status") val status: String? = "",
    @SerializedName("t_exp_month") val tExpMonth: String? = "",
    @SerializedName("t_exp_yr") val tExpYr: String? = ""
)