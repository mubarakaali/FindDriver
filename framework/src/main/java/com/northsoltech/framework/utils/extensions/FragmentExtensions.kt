package com.northsoltech.framework.utils.extensions

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

const val JE_TAG = "jejeje"

fun Fragment.safelyNavigate(directions: NavDirections, navigatorExtras: Navigator.Extras? = null) {
    try {
        if (navigatorExtras != null) findNavController().navigate(directions, navigatorExtras)
        else findNavController().navigate(directions)
    } catch (e: IllegalStateException) {
        e.printStackTrace()
        Log.d(JE_TAG, "safelyNavigate:...... $e")
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
        Log.d(JE_TAG, "safelyNavigate:...... $e")
    }

}