package com.example.teamhiring.data.repositories.recruiter

import com.example.teamhiring.data.services.RecruitManageApiService
import javax.inject.Inject

class RecruiterManageJobRepo @Inject constructor(private val recruitManageApiService: RecruitManageApiService) {

    suspend fun getPostedJobList() = recruitManageApiService.getPostedJobList()
}