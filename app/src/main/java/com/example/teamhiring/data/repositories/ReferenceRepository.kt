package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.models.StateData
import com.example.teamhiring.data.services.ReferenceApiService
import retrofit2.Response
import javax.inject.Inject

class ReferenceRepository @Inject constructor(private val referenceApiService: ReferenceApiService) {

    suspend fun getStates(): Response<List<StateData>> {
        return referenceApiService.getStateList()
    }
}