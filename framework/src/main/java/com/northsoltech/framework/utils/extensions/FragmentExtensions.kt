package com.northsoltech.framework.utils.extensions

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

const val JE_TAG = "jejeje"

fun Fragment.safelyNavigate(navDirections: NavDirections,navExtras: Navigator.Extras?=null){
    try {
        if (navExtras!=null) findNavController().navigate(navDirections,navExtras)
        else findNavController().navigate(navDirections)
    }catch (e:Exception){
        Log.d(JE_TAG, "safelyNavigate:...... $e")
    }

}