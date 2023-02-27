package com.example.teamhiring.data.repositories

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.teamhiring.data.constants.NetworkResult
import com.example.teamhiring.data.models.EmpLoginBody
import com.example.teamhiring.data.models.EmpRegisterBody
import com.example.teamhiring.data.models.LoginData
import com.example.teamhiring.data.services.LoginEmployeeService
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class EmpLoginRepository @Inject constructor(private val loginEmployeeService: LoginEmployeeService) {


//  Response is same for the Login and Registration
    private val _userResponseLiveData = MutableLiveData<NetworkResult<LoginData>>()
    val userResponseLiveData: LiveData<NetworkResult<LoginData>>
        get() = _userResponseLiveData


//    For Employee Login
    suspend fun loginUser(empLoginBody: EmpLoginBody) {
        val response = loginEmployeeService.getEmpLoginData(empLoginBody)
        Log.d(TAG, "loginUser:$response")
        handleResponse(response)
    }


//    For Employee Registration
    suspend fun registerUser(empRegisterBody: EmpRegisterBody) {
        val registerResponse = loginEmployeeService.getEmpRegisterData(empRegisterBody)
        Log.d(TAG, "registerUser:$registerResponse")
        handleResponse(registerResponse)
    }

    private fun handleResponse(response: Response<LoginData>) {
        if (response.isSuccessful && response.body() != null) {
            _userResponseLiveData.postValue(NetworkResult.Success(response.body()!!))
        }
        else if(response.errorBody()!=null){
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            _userResponseLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
        }
        else{
            _userResponseLiveData.postValue(NetworkResult.Error("Something Went Wrong"))
        }
    }
}