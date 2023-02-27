package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.CareerEmpData
import com.example.teamhiring.data.repositories.EmpProffessionalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class EmpCarPrefViewModel @Inject constructor(private val empProffRepository: EmpProffessionalRepository): ViewModel() {
    suspend fun getEmpCarPrefData(): Response<List<CareerEmpData>>{
        return withContext(Dispatchers.IO){
            empProffRepository.getEmpCarPrefData()
        }
    }
}