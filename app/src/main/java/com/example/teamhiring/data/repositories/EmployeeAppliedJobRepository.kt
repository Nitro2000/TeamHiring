package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.services.ReferenceApiService
import retrofit2.Response
import javax.inject.Inject

class EmployeeAppliedJobRepository @Inject constructor(private val referenceRepository: ReferenceApiService) {
    suspend fun getAppliedJob(): Response<List<AllJobData>> {
        return referenceRepository.getAppliedJobList()
    }


}