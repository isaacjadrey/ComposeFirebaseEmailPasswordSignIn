package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cwj.composefirebasesigninemailpassword.presentation.components.LargeSpacer
import com.cwj.composefirebasesigninemailpassword.presentation.components.SmallSpacer
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.AccountQueryText
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.AuthButton
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.EmailTextField
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.PasswordTextField
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.components.ForgotPasswordText
import com.cwj.composefirebasesigninemailpassword.util.Constants.EMPTY_VALUE
import com.cwj.composefirebasesigninemailpassword.util.Constants.LOGIN
import com.cwj.composefirebasesigninemailpassword.util.Constants.NO_ACCOUNT

@Composable
fun LoginScreen(
    navigateToForgotPassword: () -> Unit,
    navigateToSignUp: () -> Unit
) {
    var email by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(EMPTY_VALUE))
    }
    var password by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(EMPTY_VALUE))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailTextField(
            email = email,
            onValueChange = { newValue -> email = newValue },
            imeAction = ImeAction.Next
        )
        SmallSpacer()
        PasswordTextField(password = password, onValueChange = { newValue -> password = newValue })
        SmallSpacer()
        ForgotPasswordText(
            modifier = Modifier.align(alignment = Alignment.End),
            navigateToForgotPassword = navigateToForgotPassword
        )
        LargeSpacer()
        AuthButton(text = LOGIN, onClickAction = {})
        LargeSpacer()
        AccountQueryText(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = NO_ACCOUNT,
            navigateToSignUp = navigateToSignUp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen(navigateToSignUp = {}, navigateToForgotPassword = {})
}