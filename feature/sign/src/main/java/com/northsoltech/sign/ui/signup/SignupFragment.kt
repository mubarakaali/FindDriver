package com.northsoltech.sign.ui.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgument
import androidx.navigation.fragment.navArgs
import com.northsoltech.domain.models.loging.User
import com.northsoltech.framework.ui.theming.BikeTheme
import com.northsoltech.framework.utils.enums.UserType
import com.northsoltech.framework.utils.extensions.JE_TAG
import com.northsoltech.framework.utils.extensions.safelyNavigate
import com.northsoltech.sign.R
import com.northsoltech.sign.ui.screens.SignupScreen
import com.northsoltech.sign.ui.screens.UserTypeScreen
import com.northsoltech.sign.ui.signin.LoginFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignupFragment : Fragment() {

     private val viewModel: SignupViewModel by viewModels()
    private val args:SignupFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View  = ComposeView(requireContext()).apply {
        setContent {
            BikeTheme {
                val scafoldState: ScaffoldState = rememberScaffoldState()
                val coroutineScope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scafoldState
                ) {
                    SignupScreen(
                        signupViewModel = viewModel,
                        onUserAuthentcated = {
                            Log.d(JE_TAG, "SignupScreen: onUserAuthentcated... ")
                            safelyNavigate(SignupFragmentDirections.actionSignupFragmentContainerToLoginFragmentContainer())
                        },
                        onUserAuthentcateFailed = {
                            coroutineScope.launch {
                                scafoldState.snackbarHostState.showSnackbar(
                                    message = it,
                                    duration = SnackbarDuration.Short
                                )
                            }
                            Log.d(JE_TAG, "SignupScreen: onUserAuthentcateFailed... $it")
                        }
                    )
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.userType.value = args.users
    }
}