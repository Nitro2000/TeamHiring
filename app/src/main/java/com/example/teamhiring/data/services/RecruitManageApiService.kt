package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.GeneralDataModel
import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecruitManageApiService {

    @GET("previousjobdetail")
    suspend fun getPostedJobList(@Query("rec_id") recId: Int): Response<List<PostedJobData>>

    @GET("shortlisted_by_rec")
    suspend fun getSavedCandidates(
        @Query("rec_id") recId: Int,
        @Query("job_id") jobId: Int?
    ): Response<GeneralDataModel<List<RecruiterEmpData>>>

}