package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.cwj.composefirebasesigninemailpassword.util.Constants.FORGOT_PASSWORD_TEXT

@Composable
fun ForgotPasswordTextDirection(modifier: Modifier = Modifier) {
    Text(
        text = FORGOT_PASSWORD_TEXT,
        modifier = modifier.fillMaxWidth(),
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )
    )
}