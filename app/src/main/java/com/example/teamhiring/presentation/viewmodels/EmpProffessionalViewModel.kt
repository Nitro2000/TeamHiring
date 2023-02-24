package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.AllJobData
import com.example.teamhiring.data.models.EmpProffData
import com.example.teamhiring.data.repositories.EmpProffessionalRepository
import com.example.teamhiring.data.repositories.EmployeeAppliedJobRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EmpProffessionalViewModel @Inject constructor(private val empProffessionalRepository: EmpProffessionalRepository): ViewModel() {
    suspend fun getEmpProffData(): Response<EmpProffData> {
        return withContext(Dispatchers.IO) {
            empProffessionalRepository.getEmpProffData()
        }
    }


}