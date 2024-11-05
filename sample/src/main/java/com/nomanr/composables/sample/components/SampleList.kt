package com.nomanr.composables.sample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nomanr.composables.sample.AppTheme


@Composable
private fun SampleList(
    samples: List<String>,
    onSampleClick: (String) -> Unit
) {
    Column {
        SectionTitle(text = "Sample Showcase")

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(samples) { sampleName ->
                ListItem(
                    text = sampleName,
                    onClick = { onSampleClick(sampleName) }
                )
            }
        }
    }
}