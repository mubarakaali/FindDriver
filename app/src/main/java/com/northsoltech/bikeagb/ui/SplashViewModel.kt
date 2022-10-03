package com.northsoltech.bikeagb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : ViewModel() {
    private var _isTimeOut = MutableStateFlow(false)
    val isTimeOut = _isTimeOut.asStateFlow()
    init {
        goToNextScreen()
    }

    private fun goToNextScreen() {
        viewModelScope.launch {
            delay(1000)
            _isTimeOut.value = true
        }
    }
}