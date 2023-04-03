package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cwj.composefirebasesigninemailpassword.domain.model.Response
import com.cwj.composefirebasesigninemailpassword.presentation.components.ProgressBar
import com.cwj.composefirebasesigninemailpassword.util.Constants.LOGGING_IN
import com.cwj.composefirebasesigninemailpassword.util.makeToast
import com.cwj.composefirebasesigninemailpassword.util.printE

@Composable
fun LoginAction(
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit
) {
    val ctx = LocalContext.current

    when (val loginResponse = viewModel.loginResponse) {
        is Response.Loading -> ProgressBar(displayText = LOGGING_IN)
        is Response.Success -> {
            val isAccountCreated = loginResponse.data
            LaunchedEffect(key1 = isAccountCreated, block = {
                if (isAccountCreated) {
                    navigateToHome()
                    makeToast(ctx, "Logged in successfully!")
                }
            })
        }
        is Response.Failure -> loginResponse.apply {
            LaunchedEffect(key1 = e, block = {
                printE(e)
                makeToast(ctx, "$e")
            })
        }
    }
}