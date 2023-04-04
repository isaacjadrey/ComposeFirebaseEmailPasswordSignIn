package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.forgot_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    ForgotPasswordContent(navigateBack = navigateBack, sendResetEmail = { email ->
        coroutineScope.launch {
            viewModel.sendPasswordResetEmail(email)
        }
    })

    ForgotPasswordAction(navigateBack = navigateBack)
}