package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.AppliedJobData
import com.example.teamhiring.data.repositories.EmployeeAppliedJobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class EmployeeAppliedJobViewModel @Inject constructor(private val appliedJobRepository: EmployeeAppliedJobRepository): ViewModel() {
    suspend fun getAppliedJob(): Response<List<AppliedJobData>> = appliedJobRepository.getAppliedJob()
}