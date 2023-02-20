package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.services.ReferenceApiService
import retrofit2.Response
import javax.inject.Inject

class EmplyeeSavedJobRepository @Inject constructor(private val referenceApiService: ReferenceApiService) {
    suspend fun getSavedJob(): Response<List<AllJobData>> {
        return referenceApiService.getSavedJobList()
    }
}