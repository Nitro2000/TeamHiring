package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.services.ReferenceApiService
import kotlinx.coroutines.InternalCoroutinesApi
import retrofit2.Response
import javax.inject.Inject

class EmployeRepository  @Inject constructor(private val referenceApiService: ReferenceApiService){
    suspend fun getAllJobs(): Response<List<AllJobData>> {
        return referenceApiService.getAllJobList()
    }
}