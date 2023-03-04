package com.example.teamhiring.data.repositories.recruiter

import com.example.teamhiring.data.models.GeneralDataModel
import com.example.teamhiring.data.models.recruiter.RecViewedData
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import com.example.teamhiring.data.services.RecruitManageApiService
import retrofit2.Response
import javax.inject.Inject

class RecruiterManageJobRepo @Inject constructor(private val recruitManageApiService: RecruitManageApiService) {

    suspend fun getPostedJobList() = recruitManageApiService.getPostedJobList(13)

    suspend fun getSavedCandidates(recId: Int, jobId: Int?): Response<GeneralDataModel<List<RecruiterEmpData>>> {
        return recruitManageApiService.getSavedCandidates(recId, jobId)
    }

    suspend fun getViewedData(recId: Int): Response<RecViewedData> {
        return recruitManageApiService.getViewedData(recId)
    }
}