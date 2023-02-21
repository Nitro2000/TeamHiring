package com.example.teamhiring.data.models


import com.google.gson.annotations.SerializedName

data class EmpProffData(
    @SerializedName("all_previous_com")
    val allPreviousCom: List<AllPreviousCom?>? = listOf(),
    @SerializedName("new_p_details")
    val newPDetails: List<NewPDetail?>? = listOf()
)


data class AllPreviousCom(
    @SerializedName("c_name")
    val cName: String? = "",
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("created_by")
    val createdBy: String? = "",
    @SerializedName("date_from")
    val dateFrom: String? = "",
    @SerializedName("date_to")
    val dateTo: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("p_desig")
    val pDesig: String? = "",
    @SerializedName("status")
    val status: String? = ""
)


data class NewPDetail(
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("created_by")
    val createdBy: String? = "",
    @SerializedName("curr_com_desig")
    val currComDesig: String? = "",
    @SerializedName("curr_com_name")
    val currComName: String? = "",
    @SerializedName("curr_d_from")
    val currDFrom: String? = "",
    @SerializedName("curr_d_to")
    val currDTo: String? = "",
    @SerializedName("curr_notice")
    val currNotice: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("old_com_desig")
    val oldComDesig: String? = "",
    @SerializedName("old_com_name")
    val oldComName: String? = "",
    @SerializedName("old_d_from")
    val oldDFrom: String? = "",
    @SerializedName("old_d_to")
    val oldDTo: String? = ""
)