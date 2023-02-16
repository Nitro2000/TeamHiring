package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamhiring.data.models.StateData
import com.example.teamhiring.data.repositories.ReferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ReferenceViewModel @Inject constructor (private val referenceRepository: ReferenceRepository): ViewModel() {

    suspend fun getStates(): Response<List<StateData>> = referenceRepository.getStates()

}