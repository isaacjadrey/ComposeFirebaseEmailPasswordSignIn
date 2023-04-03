package com.cwj.composefirebasesigninemailpassword.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoadingText(text: String) {
    Text(text = text, color = Color.Gray, fontSize = 18.sp)
}