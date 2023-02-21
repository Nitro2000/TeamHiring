package com.example.teamhiring.data.repositories

import com.example.teamhiring.data.services.EmpProffService
import javax.inject.Inject


class EmpProffessionalRepository @Inject constructor(private val empProffService: EmpProffService) {

    suspend fun getEmpProffData() = empProffService.getEmpProffData()
}