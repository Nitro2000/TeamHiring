package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.CareerEmpData
import com.example.teamhiring.data.models.EmpProffData
import retrofit2.Response
import retrofit2.http.GET

interface EmpProffService {

    @GET("p_details?emp_id=1")
    suspend fun getEmpProffData(): Response<EmpProffData>

    @GET("career_pref_emp?emp_id=1")
    suspend fun getEmpCarPrefData(): Response<List<CareerEmpData>>
}