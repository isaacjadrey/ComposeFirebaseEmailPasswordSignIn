package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cwj.composefirebasesigninemailpassword.util.Constants.LOCK
import com.cwj.composefirebasesigninemailpassword.util.Constants.PASSWORD_LABEL
import com.cwj.composefirebasesigninemailpassword.util.Constants.PASSWORD_VISIBILITY

@Composable
fun PasswordTextField(
    password: TextFieldValue,
    onValueChange: (newValue: TextFieldValue) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { newValue -> onValueChange(newValue) },
        label = { Text(text = PASSWORD_LABEL) },
        singleLine = true,
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else PasswordVisualTransformation(),
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Lock, contentDescription = LOCK)
        },
        trailingIcon = {
            val icon = if (passwordVisibility) { Icons.Filled.Visibility } else
                Icons.Filled.VisibilityOff
            IconButton(onClick = {passwordVisibility = !passwordVisibility}) {
                Icon(imageVector = icon, contentDescription = PASSWORD_VISIBILITY)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus()}
        )
    )
}

@Preview
@Composable
fun PasswordPreview() {
    PasswordTextField(password = TextFieldValue(PASSWORD_LABEL), onValueChange = {})
}