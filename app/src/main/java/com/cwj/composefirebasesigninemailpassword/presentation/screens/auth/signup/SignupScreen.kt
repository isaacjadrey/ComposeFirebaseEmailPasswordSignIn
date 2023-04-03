package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cwj.composefirebasesigninemailpassword.presentation.components.BigSpacer
import com.cwj.composefirebasesigninemailpassword.presentation.components.LargeSpacer
import com.cwj.composefirebasesigninemailpassword.presentation.components.SmallSpacer
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.AccountQueryText
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.AuthButton
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.EmailTextField
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.PasswordTextField
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.components.ForgotPasswordText
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.login.LoginScreen
import com.cwj.composefirebasesigninemailpassword.util.Constants
import com.cwj.composefirebasesigninemailpassword.util.Constants.HAVE_ACCOUNT
import com.cwj.composefirebasesigninemailpassword.util.Constants.SIGNUP
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit,
    viewModel: SignupViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    SignUpContent(navigateToLogin = navigateToLogin, signupUser = {email, password ->
        coroutineScope.launch {
            viewModel.signupUserWithEmailAndPassword(email, password )
        }
    })

    SignUpAction(navigateToHome = navigateToHome)
}