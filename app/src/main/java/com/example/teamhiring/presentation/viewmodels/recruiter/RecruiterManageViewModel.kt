package com.example.teamhiring.presentation.viewmodels.recruiter

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.recruiter.PostedJobData
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
}