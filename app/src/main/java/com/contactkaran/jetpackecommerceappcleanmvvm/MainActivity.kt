package com.contactkaran.jetpackecommerceappcleanmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.home.HomeScreen
import com.contactkaran.jetpackecommerceappcleanmvvm.ui.theme.JetpackEcommerceAppCleanMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackEcommerceAppCleanMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(onNavigate = {})
                }
            }
        }
    }
}
