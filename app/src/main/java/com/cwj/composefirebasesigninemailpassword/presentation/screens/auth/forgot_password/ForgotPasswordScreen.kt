package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.forgot_password

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cwj.composefirebasesigninemailpassword.presentation.components.LargeSpacer
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.AuthButton
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.EmailTextField
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.components.ForgotPasswordTextDirection
import com.cwj.composefirebasesigninemailpassword.util.Constants
import com.cwj.composefirebasesigninemailpassword.util.Constants.RESET_PASSWORD

@Composable
fun ForgotPasswordScreen() {
    var email by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(Constants.EMPTY_VALUE))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ForgotPasswordTextDirection()
        LargeSpacer()
        EmailTextField(email = email, onValueChange = { newValue -> email = newValue })
        LargeSpacer()
        AuthButton(text = RESET_PASSWORD, onClickAction = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPreview() {
    ForgotPasswordScreen()
}