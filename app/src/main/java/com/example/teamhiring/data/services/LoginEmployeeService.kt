package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.EmpLoginBody
import com.example.teamhiring.data.models.EmpProffData
import com.example.teamhiring.data.models.LoginData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface LoginEmployeeService {

    @GET("employee_login")
    suspend fun getEmpLoginData(@Body empLoginBody: EmpLoginBody): Response<LoginData>
}