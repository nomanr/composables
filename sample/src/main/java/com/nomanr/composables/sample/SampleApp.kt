package com.nomanr.composables.sample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nomanr.composables.sample.samples.SliderSample

sealed class Screen {
    data object SampleList : Screen()
    data class Sample(val name: String) : Screen()
}

val samples = mapOf<String, @Composable () -> Unit>(
    "Slider Sample" to { SliderSample() },
)

@Composable
fun SampleApp() {

    var currentScreen by remember { mutableStateOf<Screen>(Screen.SampleList) }

    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 24.dp)
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
                        BasicText(
                            text = "Back",
                            style = AppTheme.typography.subtitle,
                            modifier = Modifier
                                .clickable { currentScreen = Screen.SampleList }
                                .padding(bottom = 16.dp)
                        )

                        BasicText(
                            "Slider Sample",
                            style = AppTheme.typography.h1
                        )
                        Spacer(modifier = Modifier.height(32.dp))

                        val sampleName = (currentScreen as Screen.Sample).name
                        samples[sampleName]?.invoke()
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
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        BasicText(
            text = name,
            style = AppTheme.typography.subtitle
        )
    }
}
