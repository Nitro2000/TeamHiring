package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.SavedJobData
import com.example.teamhiring.data.services.ReferenceApiService
import retrofit2.Response
import javax.inject.Inject

class EmplyeeSavedJobRepository @Inject constructor(private val referenceApiService: ReferenceApiService) {
    suspend fun getSavedJob(): Response<List<SavedJobData>> {
        return referenceApiService.getSavedJobList()
    }
}