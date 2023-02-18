package com.example.teamhiring.presentation.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.SavedJobData
import com.example.teamhiring.data.repositories.EmplyeeSavedJobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EmployeeSavedJobViewModel @Inject constructor(private val savedJobRepository: EmplyeeSavedJobRepository): ViewModel() {
    suspend fun getSavedJobs(): Response<List<SavedJobData>> = savedJobRepository.getSavedJob()
}