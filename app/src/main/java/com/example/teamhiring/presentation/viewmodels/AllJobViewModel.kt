package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.repositories.EmployeeJobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class AllJobViewModel  @Inject constructor(private val allJobRepository: EmployeeJobRepository): ViewModel(){


//    init {
//        getAllJobs()
//    }
//    fun getAllJobs(){
//        viewModelScope.launch {
//            var allJobs = allJobRepository.getAllJobs()
//
//        }
//    }

    suspend fun getAllJobs(): Response<List<AllJobData>> = allJobRepository.getAllJobs()
    suspend fun getAppliedJob(): Response<List<AllJobData>> = allJobRepository.getAppliedJob()
    suspend fun getSavedJobs(): Response<List<AllJobData>> = allJobRepository.getSavedJob()


}