package com.example.teamhiring.presentation.viewmodels

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamhiring.CommonUiFunctions
import com.example.teamhiring.data.constants.NetworkResult
import com.example.teamhiring.data.models.EmpLoginBody
import com.example.teamhiring.data.models.EmpRegisterBody
import com.example.teamhiring.data.models.LoginData
import com.example.teamhiring.data.repositories.EmpLoginRepository
import com.example.teamhiring.helpers.ProgressDialog.binding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmpLoginViewModel @Inject constructor(private val empLoginRepository: EmpLoginRepository): ViewModel() {


    val userResponseLiveData: LiveData<NetworkResult<LoginData>>
        get() = empLoginRepository.userResponseLiveData


//    For Employee Login
    fun loginUser(empLoginBody: EmpLoginBody){
        viewModelScope.launch {
            empLoginRepository.loginUser(empLoginBody)
        }

    }


//    For Employee Register
    fun registerUser(empRegisterBody: EmpRegisterBody){
        viewModelScope.launch {
            empLoginRepository.registerUser(empRegisterBody)
        }
    }


    fun validateLoginCredentials(emailAddress: String,password: String,
                            isLogin: Boolean) : Pair<Boolean, String> {

        var result = Pair(true, "")
        if(TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(password)){
            result = Pair(false, "Please provide the credentials")
        }
        else if(!CommonUiFunctions.isValidEmail(emailAddress)){
            result = Pair(false, "Email is invalid")
        }
        else if(!TextUtils.isEmpty(password) && password.length <= 5){
            result = Pair(false, "Password length should be greater than 5")
        }
        return result
    }

    fun validateRegisterCredentials(empName: String, emailAddress: String,mobile: String,password: String,
                            isRegister: Boolean) : Pair<Boolean, String> {

        var result = Pair(true, "")
        if(TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(password) || TextUtils.isEmpty(empName) || TextUtils.isEmpty(mobile)){
            result = Pair(false, "Please provide the credentials")
        }
        else if(!CommonUiFunctions.isValidEmail(emailAddress)){
            result = Pair(false, "Email is invalid")
        }
        else if(!TextUtils.isEmpty(password) && password.length <= 5){
            result = Pair(false, "Password length should be greater than 5")
        }
        return result
    }
}