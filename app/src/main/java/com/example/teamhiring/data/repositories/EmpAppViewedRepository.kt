package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.models.EmpAppViewedData
import com.example.teamhiring.data.services.ReferenceApiService
import retrofit2.Response
import javax.inject.Inject

class EmpAppViewedRepository @Inject constructor(private val referenceApiService: ReferenceApiService) {
    suspend fun getViewedByList(): Response<List<EmpAppViewedData>>{
        return referenceApiService.getViewedByList()
    }

}