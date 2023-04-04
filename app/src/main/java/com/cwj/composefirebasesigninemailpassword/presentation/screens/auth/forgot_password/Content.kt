package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.forgot_password

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cwj.composefirebasesigninemailpassword.presentation.components.LargeSpacer
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.AuthButton
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common.EmailTextField
import com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.components.ForgotPasswordTextDirection
import com.cwj.composefirebasesigninemailpassword.util.Constants

@Composable
fun ForgotPasswordContent(
    navigateBack: () -> Unit,
    sendResetEmail: (email: String) -> Unit
) {
    var email by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(Constants.EMPTY_VALUE))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(40.dp)
                .clickable { navigateBack() }
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = Icons.Filled.NavigateBefore, contentDescription = Constants.BACK)
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ForgotPasswordTextDirection()
            LargeSpacer()
            EmailTextField(
                email = email,
                onValueChange = { newValue -> email = newValue },
                imeAction = ImeAction.Done
            )
            LargeSpacer()
            AuthButton(
                text = Constants.RESET_PASSWORD,
                onClickAction = { sendResetEmail(email.text) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPreview() {
    ForgotPasswordScreen(navigateBack = {})
}