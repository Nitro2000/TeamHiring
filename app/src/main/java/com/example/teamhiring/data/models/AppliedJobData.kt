package com.example.teamhiring.data.models

import com.google.gson.annotations.SerializedName

data class AppliedJobData(

    @SerializedName("id") val jobAppliedId: String?,
    @SerializedName("jTitle") val jobAppliedTitle: String?,
    @SerializedName("nOpen") val noOfAppliedOpenings: String?,
    @SerializedName("state") val jobAppliedState: String?,
    @SerializedName("District") val jobAppliedDistrict: String?,
    @SerializedName("city") val jobAppliedCity: String?,
    @SerializedName("zip") val jobAppliedZip: String?,
    @SerializedName("adress") val jobAppliedAddress: String?,
    @SerializedName("emp_type") val jobAppliedEmpType: String?,
    @SerializedName("jobtype") val jobAppliedJobType: String?,
    @SerializedName("shift") val jobAppliedShift: String?,
    @SerializedName("experience") val jobAppliedExperience: String?,
    @SerializedName("quali") val jobAppliedQualification: String?,
    @SerializedName("c_eng") val jobAppliedEnglishLabel: String?,
    @SerializedName("sMin") val jobAppliedExMinSalary: String?,
    @SerializedName("sMax") val jobAppliedExMaxSalary: String?,
    @SerializedName("jobDescription") val jobAppliedDescription: String?,
    @SerializedName("skills") val jobAppliedSkills: String?,
    @SerializedName("inJobTime") val jobAppliedInTime: String?,
    @SerializedName("inJobTimeType") val jobAppliedInTimeType: String?,
    @SerializedName("outJobTime") val jobAppliedOutTime: String?,
    @SerializedName("outJobTimeType") val jobAppliedOutTimeType: String?,
    @SerializedName("dayFrom") val jobAppliedDayFrom: String?,
    @SerializedName("dayTo") val jobAppliedDayTo: String?,
    @SerializedName("status") val jobAppliedStatus: String?,
    @SerializedName("created_at") val jobAppliedCreatedAt: String?,
    @SerializedName("created_by") val jobAppliedCreatedBy: String?,
)