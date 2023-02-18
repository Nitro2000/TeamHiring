package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.EmpAppViewedData
import com.example.teamhiring.data.repositories.EmpAppViewedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EmpViewedByViewModel @Inject constructor(private val empAppViewedRepository: EmpAppViewedRepository): ViewModel() {
    suspend fun getViewedByList(): Response<List<EmpAppViewedData>> = empAppViewedRepository.getViewedByList()
}