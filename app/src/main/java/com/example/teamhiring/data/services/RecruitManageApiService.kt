package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.data.models.recruiter.RecruiterData
import retrofit2.Response
import retrofit2.http.GET

interface RecruitManageApiService {

    @GET("previousjobdetail?rec_id=12")
    suspend fun getPostedJobList(): Response<List<PostedJobData>>
}