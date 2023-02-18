package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.*
import retrofit2.Response
import retrofit2.http.GET

interface ReferenceApiService {

    @GET("all_db_states")
    suspend fun getStateList(): Response<List<StateData>>

    @GET("all_jobs")
    suspend fun getAllJobList(): Response<List<AllJobData>>

    @GET("appliedjob?emp_id=5")
    suspend fun getAppliedJobList(): Response<List<AppliedJobData>>

    @GET("saved_jobs?emp_id=1")
    suspend fun getSavedJobList(): Response<List<SavedJobData>>

    @GET("saved_jobs?emp_id=1")
    suspend fun getViewedByList(): Response<List<EmpAppViewedData>>
}