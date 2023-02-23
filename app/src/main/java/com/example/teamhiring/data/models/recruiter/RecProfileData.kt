package com.example.teamhiring.data.models.recruiter


import com.google.gson.annotations.SerializedName

data class RecProfileData(
    @SerializedName("adress") val adress: String? = "",
    @SerializedName("c_desc") val cDesc: String? = "",
    @SerializedName("c_gst") val cGst: String? = "",
    @SerializedName("c_logo") val cLogo: String? = "",
    @SerializedName("city") val city: String? = "",
    @SerializedName("com_type") val comType: String? = "",
    @SerializedName("created_at") val createdAt: String? = "",
    @SerializedName("created_by") val createdBy: String? = "",
    @SerializedName("District") val district: String? = "",
    @SerializedName("documents") val documents: String? = "",
    @SerializedName("email") val email: String? = "",
    @SerializedName("id") val id: String? = "",
    @SerializedName("link") val link: String? = "",
    @SerializedName("n_emp") val nEmp: String? = "",
    @SerializedName("name") val name: String? = "",
    @SerializedName("number") val number: String? = "",
    @SerializedName("r_desig") val rDesig: String? = "",
    @SerializedName("r_mobile") val rMobile: String? = "",
    @SerializedName("r_name") val rName: String? = "",
    @SerializedName("state") val state: String? = "",
    @SerializedName("status") val status: String? = "",
    @SerializedName("zip") val zip: String? = ""
)