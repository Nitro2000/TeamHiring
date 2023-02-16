package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teamhiring.data.repositories.RecruiterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecruiterViewModel @Inject constructor(private val recruiterRepository: RecruiterRepository) :
    ViewModel() {

        suspend fun getEmpList() = recruiterRepository.getEmpList()

}