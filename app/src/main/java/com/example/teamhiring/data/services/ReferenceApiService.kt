package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.StateData
import retrofit2.Response
import retrofit2.http.GET

interface ReferenceApiService {

    @GET("all_db_states")
    suspend fun getStateList(): Response<List<StateData>>
}