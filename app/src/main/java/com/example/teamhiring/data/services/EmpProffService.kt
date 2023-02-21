package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.EmpProffData
import retrofit2.Response
import retrofit2.http.GET

interface EmpProffService {

    @GET("p_details?emp_id=1")
    suspend fun getEmpProffData(): Response<EmpProffData>
}