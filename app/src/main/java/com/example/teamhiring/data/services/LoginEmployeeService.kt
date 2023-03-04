package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.EmpLoginBody
import com.example.teamhiring.data.models.EmpRegisterBody
import com.example.teamhiring.data.models.LoginData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface LoginEmployeeService {

    @GET("employee_login")
    suspend fun getEmpLoginData(@Body empLoginBody: EmpLoginBody): Response<LoginData>

    @GET("employee_Register")
    suspend fun getEmpRegisterData(@Body empRegisterBody: EmpRegisterBody): Response<LoginData>
}