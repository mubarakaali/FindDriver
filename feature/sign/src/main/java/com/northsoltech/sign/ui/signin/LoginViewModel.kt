package com.northsoltech.sign.ui.signin

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.repositories.signing.SigningRepository
import com.northsoltech.framework.states.UiState
import com.northsoltech.framework.utils.extensions.JE_TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
     private val signingRepository: SigningRepository
) : ViewModel() {

     val uiState = mutableStateOf<UiState>(UiState.Idle)

     fun userLogin(phoneNo:String,password:String,onUserAuthentcated:()->Unit,onUserAuthentcateFailed:(error:String)->Unit){
          viewModelScope.launch {
               Log.d(JE_TAG, "userLogin: phoneNo $phoneNo,  password $password")
               if (phoneNo.isEmpty()|| password.isEmpty()){
                    onUserAuthentcateFailed("Please fill the data correctly")
                    return@launch
               }
               signingRepository.signing(
                    phoneNo = phoneNo,
                    password = password
               ).collect{
                    when(it){
                         is ApiResource.Loading ->{
                              uiState.value = UiState.Loading
                         }
                         is ApiResource.Valid ->{
                              uiState.value = UiState.Success
                              Log.d(JE_TAG, "viewModel userLogin Sucess ${it.data}")
                              if (it.data.token==null){
                                   onUserAuthentcateFailed("Something went wrong")
                              }else{
                                   onUserAuthentcated()
                              }
                         }
                         is ApiResource.Invalid ->{
                              uiState.value = UiState.Error(it.message)
                              onUserAuthentcateFailed(it.message)
                         }
                    }
               }
          }

     }
}