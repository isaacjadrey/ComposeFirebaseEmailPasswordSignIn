package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.forgot_password

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.cwj.composefirebasesigninemailpassword.domain.model.Response
import com.cwj.composefirebasesigninemailpassword.presentation.components.ProgressBar
import com.cwj.composefirebasesigninemailpassword.util.Constants.PASSWORD_RESET_MESSAGE
import com.cwj.composefirebasesigninemailpassword.util.makeToast
import com.cwj.composefirebasesigninemailpassword.util.printE

@Composable
fun ForgotPasswordAction(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val ctx = LocalContext.current

    when(val passwordResetResponse = viewModel.passwordResetResponse) {
        is Response.Loading -> ProgressBar(displayText = "")
        is Response.Success -> {
            val isEmailSent = passwordResetResponse.data
            LaunchedEffect(key1 = isEmailSent, block = {
                if (isEmailSent) {
                    navigateBack()
                    makeToast(ctx, PASSWORD_RESET_MESSAGE, Toast.LENGTH_LONG)
                }
            })
        }
        is Response.Failure -> passwordResetResponse.apply {
            LaunchedEffect(key1 = e, block = {
                printE(e)
                makeToast(ctx, "${e.message}", Toast.LENGTH_SHORT)
            })
        }
    }
}