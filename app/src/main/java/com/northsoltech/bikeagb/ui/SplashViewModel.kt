package com.northsoltech.bikeagb.ui

import android.util.Log
import androidx.lifecycle.*
import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.repositories.signing.SigningRepository
import com.northsoltech.framework.utils.extensions.JE_TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    signingRepository: SigningRepository,
) : ViewModel() {
    private var _isTimeOut = MutableStateFlow(false)
    val isTimeOut = _isTimeOut.asStateFlow()

    private var _test = MutableLiveData<String>()
    val testData: LiveData<String> = _test

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