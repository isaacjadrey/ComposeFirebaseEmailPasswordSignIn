package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.cwj.composefirebasesigninemailpassword.util.Constants.FORGOT_PASSWORD

@Composable
fun ForgotPasswordText(modifier: Modifier = Modifier) {
    Text(text = FORGOT_PASSWORD, fontSize = 16.sp, modifier = modifier.fillMaxWidth(), textAlign = TextAlign.End)
}