package com.northsoltech.bikeagb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.northsoltech.bikeagb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setContent {
//            BikeaGbTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
//            }
//        }
    }
}