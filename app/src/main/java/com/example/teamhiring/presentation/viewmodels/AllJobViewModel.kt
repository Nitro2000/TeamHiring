package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.repositories.EmployeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class AllJobViewModel  @Inject constructor(private val allJobRepository: EmployeRepository): ViewModel(){


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

}