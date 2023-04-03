package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.cwj.composefirebasesigninemailpassword.util.Constants.EMAIL
import com.cwj.composefirebasesigninemailpassword.util.Constants.EMAIL_LABEL
import kotlinx.coroutines.job

@Composable
fun EmailTextField(
    email: TextFieldValue,
    onValueChange: (newValue: TextFieldValue) -> Unit
) {
    val focusManager = LocalFocusManager.current
    val focusRequester = FocusRequester()

    OutlinedTextField(
        value = email,
        onValueChange = {newValue -> onValueChange(newValue)},
        label = { Text(text = EMAIL_LABEL)},
        singleLine = true,
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = EMAIL)},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(onNext = {focusManager.moveFocus(FocusDirection.Down)}),
        modifier = Modifier.fillMaxWidth().focusRequester(focusRequester)
    )

    LaunchedEffect(key1 = Unit, block = {
        coroutineContext.job.invokeOnCompletion { focusRequester.requestFocus() }
    })
}

@Preview
@Composable
fun EmailPreview() {
    EmailTextField(email = TextFieldValue(EMAIL_LABEL), onValueChange = {})
}