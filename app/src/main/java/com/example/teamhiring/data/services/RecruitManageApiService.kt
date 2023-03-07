package com.example.teamhiring.data.services

import com.example.teamhiring.data.models.GeneralDataModel
import com.example.teamhiring.data.models.GeneralMessModel
import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.data.models.recruiter.RecViewedData
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

    @GET("rec_viewed_by_detail")
    suspend fun getViewedData(
        @Query("rec_id") recId: Int
    ): Response<RecViewedData>

    @GET("rec_shortList_emp")
    suspend fun callShortListApi(
        @Query("emp_id") empId: Int,
        @Query("rec_id") recId: Int
    ): Response<GeneralMessModel>

    @GET("active_deactive_job")
    suspend fun callPostJobStatusApi(
        @Query("job_id") jobId: Int
    ): Response<GeneralMessModel>
}