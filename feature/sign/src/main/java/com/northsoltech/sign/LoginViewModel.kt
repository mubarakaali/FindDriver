package com.northsoltech.sign

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.northsoltech.framework.states.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {

     val uiState = mutableStateOf<UiState>(UiState.Idle)

//     fun userLogin(phoneNo:String,password:String,onUserAuthentcated:()->Unit,onUserAuthentcateFailed:(error:String)->Unit){
//          viewModelScope.launch {
//               Log.d(JE_TAG, "userLogin: phoneNo $phoneNo,  password $password")
//               signingRepository.signing(
//                    phoneNo = phoneNo,
//                    password = password
//               ).collect{
//                    when(it){
//                         is ApiResource.Loading ->{
//                              uiState.value = UiState.Loading
//                         }
//                         is ApiResource.Valid ->{
//                              uiState.value = UiState.Success
//                              Log.d(JE_TAG, "viewModel userLogin Sucess ${it.data}")
//                              onUserAuthentcated()
//                         }
//                         is ApiResource.Invalid ->{
//                              uiState.value = UiState.Error(it.message)
//                              onUserAuthentcateFailed(it.message)
//                         }
//                    }
//               }
//          }
//
//     }
}