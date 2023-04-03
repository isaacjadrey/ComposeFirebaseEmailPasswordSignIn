package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cwj.composefirebasesigninemailpassword.domain.model.Response
import com.cwj.composefirebasesigninemailpassword.presentation.components.ProgressBar
import com.cwj.composefirebasesigninemailpassword.util.Constants.SIGNING_UP
import com.cwj.composefirebasesigninemailpassword.util.makeToast
import com.cwj.composefirebasesigninemailpassword.util.printE

@Composable
fun SignUpAction(
    viewModel: SignupViewModel = hiltViewModel(),
    navigateToHome: () -> Unit
) {
    val ctx = LocalContext.current
    when (val signupResponse = viewModel.signupResponse) {
        is Response.Loading -> ProgressBar(displayText = SIGNING_UP)
        is Response.Success -> {
            val isAccountCreated = signupResponse.data
            LaunchedEffect(key1 = isAccountCreated, block = {
                if (isAccountCreated) {
                    navigateToHome()
                    makeToast(ctx, "Account created")
                }
            })
        }
        is Response.Failure -> signupResponse.apply {
            LaunchedEffect(key1 = e, block = { printE(e) })
        }
    }
}