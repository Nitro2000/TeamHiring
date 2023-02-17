package com.example.teamhiring.presentation.viewmodels

import androidx.lifecycle.*
import com.example.teamhiring.storage.DataStoreManager
import com.example.teamhiring.storage.DataStoreManagerImpl.Companion.ALREADY_LOGIN
import com.example.teamhiring.storage.DataStoreManagerImpl.Companion.USER_TYPE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommonViewModel @Inject constructor(private val dataStore: DataStoreManager): ViewModel() {

//    private var _userTypeEmp: MutableLiveData<Boolean> = MutableLiveData()
//    val userTypeEmp: LiveData<Boolean> get() = _userTypeEmp

//    var userLogin = false

    fun saveUserType(isEmployee: Boolean) {
        viewModelScope.launch {
            dataStore.put(USER_TYPE, isEmployee)
        }
    }

    fun getUserType() = dataStore.get(USER_TYPE, true).asLiveData()

    fun saveLogin(isLogin: Boolean) {
        viewModelScope.launch {
            dataStore.put(ALREADY_LOGIN, isLogin)
        }
    }

    fun getLogin() = dataStore.get(ALREADY_LOGIN, false).asLiveData()



}