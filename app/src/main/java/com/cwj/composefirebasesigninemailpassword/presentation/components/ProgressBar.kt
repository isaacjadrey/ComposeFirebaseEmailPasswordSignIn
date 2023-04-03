package com.cwj.composefirebasesigninemailpassword.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cwj.composefirebasesigninemailpassword.util.Constants.LOGGING_IN

@Composable
fun ProgressBar(displayText: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        BigSpacer()
        LoadingText(text = displayText)
    }
}

@Preview
@Composable
fun ProgressPreview() {
    ProgressBar(displayText = LOGGING_IN)
}