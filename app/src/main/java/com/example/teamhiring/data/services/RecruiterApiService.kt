package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.recruiter.RecProfileData
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import retrofit2.Response
import retrofit2.http.GET


interface RecruiterApiService {

    @GET("employee_details")
    suspend fun getEmpList(): Response<List<RecruiterEmpData>>

    @GET("aboutcompany")
    suspend fun getRecProfileData(): Response<List<RecProfileData>>
}