package com.example.teamhiring.data.repositories.recruiter

import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import com.example.teamhiring.data.services.RecruiterApiService
import retrofit2.Response
import javax.inject.Inject

class RecruiterRepository @Inject constructor(private val recruiterApiService: RecruiterApiService) {

    suspend fun getEmpList() : Response<List<RecruiterEmpData>> {
        return recruiterApiService.getEmpList()
    }
}