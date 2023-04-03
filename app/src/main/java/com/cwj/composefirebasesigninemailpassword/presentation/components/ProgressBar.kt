package com.cwj.composefirebasesigninemailpassword.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cwj.composefirebasesigninemailpassword.util.Constants.LOGGING_IN

@Composable
fun ProgressBar(displayText: String) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Transparent.copy(alpha = 0.8f)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        BigSpacer()
        LoadingText(text = displayText)
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressPreview() {
    ProgressBar(displayText = LOGGING_IN)
}