package com.northsoltech.sign.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.northsoltech.framework.ui.theming.BikeTheme
import com.northsoltech.framework.utils.extensions.safelyNavigate
import com.northsoltech.sign.R
import com.northsoltech.sign.ui.screens.UserTypeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserTypeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = ComposeView(requireContext()).apply {
        setContent {
            BikeTheme {
                UserTypeScreen(onButtonClicked = {
                safelyNavigate(
                    UserTypeFragmentDirections.actionUserTypeFragmentContainerToSignupFragmentContainer(it)
                )
                })
            }
        }
    }
}