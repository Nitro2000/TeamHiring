package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.RecruiterData
import com.example.teamhiring.data.services.RecruiterApiService
import retrofit2.Response
import javax.inject.Inject

class RecruiterRepository @Inject constructor(private val recruiterApiService: RecruiterApiService) {

    suspend fun getEmpList() : Response<List<RecruiterData>> {
        return recruiterApiService.getEmpList()
    }
}