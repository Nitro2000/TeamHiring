package com.example.teamhiring.presentation.viewmodels.recruiter

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.recruiter.RecProfileData
import com.example.teamhiring.data.models.recruiter.RecruiterEmpData
import com.example.teamhiring.data.repositories.recruiter.RecruiterRepository
import com.example.teamhiring.ui.mainFragments.recruiter.RecruiterProfileFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RecruiterViewModel @Inject constructor(private val recruiterRepository: RecruiterRepository) :
    ViewModel() {

        suspend fun getEmpList() : Response<List<RecruiterEmpData>> {
            return withContext(Dispatchers.IO) {
                recruiterRepository.getEmpList()
            }
        }

    suspend fun getRecProfileData() : Response<List<RecProfileData>> {
        return withContext(Dispatchers.IO) {
            recruiterRepository.getRecProfileData()
        }
    }

}