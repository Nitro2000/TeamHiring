package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.repositories.EmplyeeSavedJobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EmpManageJobViewModel @Inject constructor(private val savedJobRepository: EmplyeeSavedJobRepository): ViewModel() {
    suspend fun getSavedJobs(): Response<List<AllJobData>> = savedJobRepository.getSavedJob()
}