package com.northsoltech.sign.ui.signin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ComposeView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.northsoltech.framework.FrameNavGraphDirections
import com.northsoltech.framework.ui.theming.BikeTheme
import com.northsoltech.framework.utils.extensions.JE_TAG
import com.northsoltech.framework.utils.extensions.safelyNavigate
import com.northsoltech.sign.ui.screens.LoginScreen
import com.northsoltech.sign.ui.signup.SignupFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = ComposeView(requireContext()).apply {
        setContent {
            BikeTheme {
                val scafoldState:ScaffoldState = rememberScaffoldState()
                val coroutineScope = rememberCoroutineScope()
                Scaffold(
                   scaffoldState = scafoldState
                ) {
                    LoginScreen(
                        loginViewModel = loginViewModel,
                        onUserAuthentcated = {
                            Log.d(JE_TAG, "LoginFragment onCreateView: onUserAuthenticated")
                        },
                        onUserAuthentcateFailed = {
                            Log.d(JE_TAG, "LoginFragment onCreateView: onUserAuthentcateFailed $it")
                            coroutineScope.launch {
                                scafoldState.snackbarHostState.showSnackbar(
                                    message = it,
                                    duration = SnackbarDuration.Short
                                )
                            }

                        },
                        onUserSignupListener = {
                            navigateToUserTypeScreen()
                        }
                    )
                }

            }
        }
    }
    private fun navigateToUserTypeScreen(){
        safelyNavigate(LoginFragmentDirections.actionLoginFragmentContainerToUserTypeFragmentContainer())
    }
}