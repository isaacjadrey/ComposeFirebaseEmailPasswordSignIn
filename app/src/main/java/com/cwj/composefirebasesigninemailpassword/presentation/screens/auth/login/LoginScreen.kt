package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToForgotPassword: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToHome: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    LoginContent(
        navigateToForgotPassword = navigateToForgotPassword,
        navigateToSignUp = navigateToSignUp,
        login = {email, password ->
            coroutineScope.launch {
                viewModel.signInUserWIthEmailPassword(email, password)
            }
        }
    )
    LoginAction(navigateToHome = navigateToHome)
}