package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.EmpBasicDetail
import com.example.teamhiring.data.models.EmpCareerPrefeData
import com.example.teamhiring.data.models.EmpExpData
import com.example.teamhiring.data.models.recruiter.RecProfileData
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface RecruiterApiService {

    @GET("employee_details")
    suspend fun getEmpList(@Query("job_id") jobId: Int?): Response<List<RecruiterEmpData>>

    @GET("aboutcompany")
    suspend fun getRecProfileData(@Query("rec_id") recId: Int): Response<List<RecProfileData>>

    @GET("career_pref_emp")
    suspend fun getEmpCareerPref(@Query("emp_id") empId: Int): Response<List<EmpCareerPrefeData>>

    @GET("p_details")
    suspend fun getEmpExpData(@Query("emp_id") empId: Int): Response<EmpExpData>

    @GET("employee_details")
    suspend fun getEmpBasicData(@Query("emp_id") empId: Int): Response<List<EmpBasicDetail>>
}