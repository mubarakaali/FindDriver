package com.northsoltech.bikeagb.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel:ViewModel() {
    private var _isTimeOut = MutableStateFlow(false)
    val isTimeOut = _isTimeOut.asStateFlow()

    init {
        goToNextScreen()
    }
    private fun goToNextScreen(){
        viewModelScope.launch {
            delay(3000)
            _isTimeOut.value = true
        }
    }
}