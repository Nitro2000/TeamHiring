package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.models.EmpExpData
import com.example.teamhiring.data.repositories.EmpProffessionalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class EmpProffessionalViewModel @Inject constructor(private val empProffessionalRepository: EmpProffessionalRepository): ViewModel() {
    suspend fun getEmpProffData(): Response<EmpExpData> {
        return withContext(Dispatchers.IO) {
            empProffessionalRepository.getEmpProffData()
        }
    }


}