package com.nomanr.composables.sample

import BottomSheetSample
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nomanr.composables.sample.components.BackButton
import com.nomanr.composables.sample.components.SectionTitle
import com.nomanr.composables.sample.samples.SliderSample

sealed class Screen {
    data object SampleList : Screen()
    data class Sample(val name: String) : Screen()
}

val samples = mapOf<String, @Composable () -> Unit>(
    "Slider Sample" to { SliderSample() },
    "Bottom Sheet Sample" to { BottomSheetSample() }
)

@Composable
fun SampleApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.SampleList) }

    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 32.dp)
        ) {
            when (currentScreen) {
                is Screen.SampleList -> {
                    SampleList(
                        samples = samples.keys.toList(),
                        onSampleClick = { sampleName ->
                            currentScreen = Screen.Sample(sampleName)
                        }
                    )
                }

                is Screen.Sample -> {
                    Column {
                        BackButton(
                            onClick = { currentScreen = Screen.SampleList }
                        )

                        val sampleName = (currentScreen as Screen.Sample).name
                        SectionTitle(text = sampleName)
                        Box(Modifier.fillMaxSize()) {
                            samples[sampleName]?.invoke()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SampleList(
    samples: List<String>,
    onSampleClick: (String) -> Unit
) {
    Column {
        BasicText(
            text = "Sample Showcase",
            style = AppTheme.typography.h1,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(samples) { sampleName ->
                SampleItem(
                    name = sampleName,
                    onClick = { onSampleClick(sampleName) }
                )
            }
        }
    }
}

@Composable
private fun SampleItem(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = AppTheme.colors.surface,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = AppTheme.colors.divider,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicText(
                text = name,
                style = AppTheme.typography.subtitle
            )
            BasicText(
                text = "→",
                style = AppTheme.typography.subtitle.copy(
                    color = AppTheme.colors.primary
                )
            )
        }
    }
}
