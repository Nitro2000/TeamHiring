package com.example.teamhiring.data.repositories.recruiter

import com.example.teamhiring.data.models.EmpBasicDetail
import com.example.teamhiring.data.models.EmpCareerPrefeData
import com.example.teamhiring.data.models.EmpExpData
import com.example.teamhiring.data.models.recruiter.RecProfileData
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import com.example.teamhiring.data.services.RecruiterApiService
import retrofit2.Response
import javax.inject.Inject

class RecruiterRepository @Inject constructor(private val recruiterApiService: RecruiterApiService) {

    suspend fun getEmpList(jobId: Int?) : Response<List<RecruiterEmpData>> {
        return recruiterApiService.getEmpList(jobId)
    }

    suspend fun getRecProfileData() : Response<List<RecProfileData>> {
        return recruiterApiService.getRecProfileData(12)
    }

    suspend fun getEmpExpData() : Response<EmpExpData> {
        return recruiterApiService.getEmpExpData(1)
    }

    suspend fun getEmpCareerPref() : Response<List<EmpCareerPrefeData>> {
        return recruiterApiService.getEmpCareerPref(1)
    }

    suspend fun getEmpBasicData(empId: Int) : Response<List<EmpBasicDetail>> {
        return recruiterApiService.getEmpBasicData(empId)
    }
}