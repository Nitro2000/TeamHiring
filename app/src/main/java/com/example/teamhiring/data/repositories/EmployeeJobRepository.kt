package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.services.ReferenceApiService
import retrofit2.Response
import javax.inject.Inject

class EmployeeJobRepository  @Inject constructor(private val referenceApiService: ReferenceApiService){
    suspend fun getAllJobs(): Response<List<AllJobData>> {
        return referenceApiService.getAllJobList()
    }

    suspend fun getAppliedJob(): Response<List<AllJobData>> {
        return referenceApiService.getAppliedJobList()
    }

    suspend fun getSavedJob(): Response<List<AllJobData>> {
        return referenceApiService.getSavedJobList()
    }
}