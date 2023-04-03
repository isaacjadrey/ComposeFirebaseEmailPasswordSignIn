package com.cwj.composefirebasesigninemailpassword.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.forgot_password.ForgotPasswordScreen
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.login.LoginScreen
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.signup.SignUpScreen
import com.cwj.composefirebasesigninemailpassword.presentation.screens.home.HomeScreen
import com.cwj.composefirebasesigninemailpassword.presentation.ui.theme.ComposeFirebaseSignInEmailPasswordTheme

class MainActivity : ComponentActivity() {
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
                    HomeScreen()
                }
            }
        }
    }
}