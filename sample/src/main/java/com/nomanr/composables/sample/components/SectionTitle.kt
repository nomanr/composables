package com.nomanr.composables.sample.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nomanr.composables.sample.AppTheme

@Composable
fun SectionTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    BasicText(
        text = text,
        style = AppTheme.typography.h1,
        modifier = modifier.padding(bottom = 16.dp)
    )
}

