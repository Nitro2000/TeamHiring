package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.AppliedJobData
import com.example.teamhiring.data.services.ReferenceApiService
import retrofit2.Response
import javax.inject.Inject

class EmployeeAppliedJobRepository @Inject constructor(private val referenceRepository: ReferenceApiService) {
    suspend fun getAppliedJob(): Response<List<AppliedJobData>> {
        return referenceRepository.getAppliedJobList()
    }


}