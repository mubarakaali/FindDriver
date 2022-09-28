package com.northsoltech.bikeagb.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.northsoltech.bikeagb.ui.screens.SplashScreen
import com.northsoltech.framework.FrameNavGraphDirections
import com.northsoltech.framework.ui.theming.BikeTheme
import com.northsoltech.framework.utils.extensions.JE_TAG
import com.northsoltech.framework.utils.extensions.safelyNavigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {
     private val viewModel: SplashViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ):View = ComposeView(requireContext()).apply {
        setContent {
            BikeTheme {
                SplashScreen()
                setObservers()
            }
        }
    }

    private fun setObservers(){
        lifecycleScope.launchWhenCreated {
            viewModel.isTimeOut.collect{
                if (it){
                    Log.d(JE_TAG, "setObservers: SplashTimeout ")
                    safelyNavigate(FrameNavGraphDirections.globalActionToOnboarding())
                }
            }
            viewModel.testData.observe(viewLifecycleOwner) {
                Log.d(JE_TAG, "setObservers:$it")
            }
        }

    }
}