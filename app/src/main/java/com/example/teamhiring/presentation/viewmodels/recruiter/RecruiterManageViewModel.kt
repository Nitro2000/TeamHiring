package com.example.teamhiring.presentation.viewmodels.recruiter

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.GeneralDataModel
import com.example.teamhiring.data.models.GeneralMessModel
import com.example.teamhiring.data.models.recruiter.PostedJobData
import com.example.teamhiring.data.models.recruiter.RecViewedData
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import com.example.teamhiring.data.repositories.recruiter.RecruiterManageJobRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RecruiterManageViewModel @Inject constructor(private val recruiterManageJobRepo: RecruiterManageJobRepo): ViewModel() {

    suspend fun getPostedJobList(): Response<List<PostedJobData>> {
        return withContext(Dispatchers.IO) {
            recruiterManageJobRepo.getPostedJobList()
        }
    }

    suspend fun getSavedCandidates(recId: Int, jobId: Int?): Response<GeneralDataModel<List<RecruiterEmpData>>> {
        return withContext(Dispatchers.IO) {
            recruiterManageJobRepo.getSavedCandidates(recId, jobId)
        }
    }

    suspend fun getViewedData(): Response<RecViewedData> {
        return withContext(Dispatchers.IO) {
            recruiterManageJobRepo.getViewedData(1)
        }
    }

    suspend fun callShortListApi(empId: Int): Response<GeneralMessModel> {
        return withContext(Dispatchers.IO) {
            recruiterManageJobRepo.callShortListApi(empId, 12)
        }
    }
}