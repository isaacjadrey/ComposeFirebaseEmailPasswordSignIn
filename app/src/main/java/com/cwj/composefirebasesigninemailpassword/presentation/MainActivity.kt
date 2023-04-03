package com.cwj.composefirebasesigninemailpassword.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.cwj.composefirebasesigninemailpassword.presentation.navigation.NavGraph
import com.cwj.composefirebasesigninemailpassword.presentation.screens.home.HomeScreen
import com.cwj.composefirebasesigninemailpassword.presentation.ui.theme.ComposeFirebaseSignInEmailPasswordTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFirebaseSignInEmailPasswordTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    LoginScreen()
//                    SignUpScreen()
//                    ForgotPasswordScreen()
//                    HomeScreen()
                    NavGraph(navController = rememberAnimatedNavController())
                }
            }
        }
    }
}