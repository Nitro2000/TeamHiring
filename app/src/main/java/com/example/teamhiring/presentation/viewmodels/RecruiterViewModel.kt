package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamhiring.data.models.RecruiterData
import com.example.teamhiring.data.repositories.RecruiterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RecruiterViewModel @Inject constructor(private val recruiterRepository: RecruiterRepository) :
    ViewModel() {

        suspend fun getEmpList() : Response<List<RecruiterData>> {
            return withContext(Dispatchers.IO) {
                recruiterRepository.getEmpList()
            }
        }

}