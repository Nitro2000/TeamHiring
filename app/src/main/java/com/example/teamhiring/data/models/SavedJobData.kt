package com.example.teamhiring.data.models

import com.google.gson.annotations.SerializedName

data class SavedJobData(
    @SerializedName("id") val jobSavedId: String?,
    @SerializedName("jTitle") val jobSavedTitle: String?,
    @SerializedName("nOpen") val noOfSavedOpenings: String?,
    @SerializedName("state") val jobSavedState: String?,
    @SerializedName("District") val jobSavedDistrict: String?,
    @SerializedName("city") val jobSavedCity: String?,
    @SerializedName("zip") val jobSavedZip: String?,
    @SerializedName("adress") val jobSavedAddress: String?,
    @SerializedName("emp_type") val jobSavedEmpType: String?,
    @SerializedName("jobtype") val jobSavedJobType: String?,
    @SerializedName("shift") val jobSavedShift: String?,
    @SerializedName("experience") val jobSavedExperience: String?,
    @SerializedName("quali") val jobSavedQualification: String?,
    @SerializedName("c_eng") val jobSavedEnglishLabel: String?,
    @SerializedName("sMin") val jobSavedExMinSalary: String?,
    @SerializedName("sMax") val jobSavedExMaxSalary: String?,
    @SerializedName("jobDescription") val jobSavedDescription: String?,
    @SerializedName("skills") val jobSavedSkills: String?,
    @SerializedName("inJobTime") val jobSavedInTime: String?,
    @SerializedName("inJobTimeType") val jobSavedInTimeType: String?,
    @SerializedName("outJobTime") val jobSavedOutTime: String?,
    @SerializedName("outJobTimeType") val jobSavedOutTimeType: String?,
    @SerializedName("dayFrom") val jobSavedDayFrom: String?,
    @SerializedName("dayTo") val jobSavedDayTo: String?,
    @SerializedName("status") val jobSavedStatus: String?,
    @SerializedName("created_at") val jobSavedCreatedAt: String?,
    @SerializedName("created_by") val jobSavedCreatedBy: String?,
)