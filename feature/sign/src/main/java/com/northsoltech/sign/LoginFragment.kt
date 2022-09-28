package com.northsoltech.sign

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.northsoltech.framework.states.UiState
import com.northsoltech.framework.ui.theming.BikeTheme
import com.northsoltech.framework.utils.extensions.JE_TAG
import com.northsoltech.sign.screens.LoginScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

//    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = ComposeView(requireContext()).apply {
        setContent {
//            val uiState = viewModel.uiState
            val uiState = mutableStateOf<UiState>(UiState.Idle)
//            viewModel.userLogin()
            BikeTheme {
                LoginScreen(
                    uiStates = uiState
                ) { phoneNo,userPassword->
//                    viewModel.userLogin(
//                        phoneNo = phoneNo,
//                        password = userPassword,
//                        onUserAuthentcated = {
//                            Log.d(JE_TAG, "LoginFragment onCreateView: onUserAuthenticated")
//                        },
//                        onUserAuthentcateFailed ={
//                            Log.d(JE_TAG, "LoginFragment onCreateView: onUserAuthentcateFailed ")
//
//                        }
//                    )
                }
            }
        }
    }
}