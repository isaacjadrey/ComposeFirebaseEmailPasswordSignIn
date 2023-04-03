package com.cwj.composefirebasesigninemailpassword.presentation.screens.auth.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun AccountQueryText(text: String, navigateToSignUp: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier.fillMaxWidth().clickable { navigateToSignUp() },
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    )
}