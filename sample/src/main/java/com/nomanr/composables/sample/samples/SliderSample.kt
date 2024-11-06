package com.nomanr.composables.sample.samples

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.nomanr.composables.slider.BasicRangeSlider
import com.nomanr.composables.slider.BasicSlider
import com.nomanr.composables.slider.RangeSliderState
import com.nomanr.composables.slider.SliderColors
import com.nomanr.composables.slider.SliderState

// Color presets for sliders
private object SliderPresets {
    val Primary = SliderColors(
        thumbColor = Color(0xFF6200EE),
        activeTrackColor = Color(0xFF6200EE),
        activeTickColor = Color(0xFF3700B3),
        inactiveTrackColor = Color(0xFFBB86FC),
        inactiveTickColor = Color(0xFFBB86FC).copy(alpha = 0.7f),
        disabledThumbColor = Color(0xFF6200EE).copy(alpha = 0.38f),
        disabledActiveTrackColor = Color(0xFF6200EE).copy(alpha = 0.38f),
        disabledActiveTickColor = Color(0xFF3700B3).copy(alpha = 0.38f),
        disabledInactiveTrackColor = Color(0xFFBB86FC).copy(alpha = 0.38f),
        disabledInactiveTickColor = Color(0xFFBB86FC).copy(alpha = 0.38f)
    )

    val Secondary = SliderColors(
        thumbColor = Color(0xFFB00020),
        activeTrackColor = Color(0xFFB00020),
        activeTickColor = Color(0xFF7F0019),
        inactiveTrackColor = Color(0xFFCF6679),
        inactiveTickColor = Color(0xFFCF6679).copy(alpha = 0.7f),
        disabledThumbColor = Color(0xFFB00020).copy(alpha = 0.38f),
        disabledActiveTrackColor = Color(0xFFB00020).copy(alpha = 0.38f),
        disabledActiveTickColor = Color(0xFF7F0019).copy(alpha = 0.38f),
        disabledInactiveTrackColor = Color(0xFFCF6679).copy(alpha = 0.38f),
        disabledInactiveTickColor = Color(0xFFCF6679).copy(alpha = 0.38f)
    )
}

@Composable
fun SliderSample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Section("Basic Sliders") { BasicSliderExamples() }
            Section("Range Sliders") { RangeSliderExamples() }
            Section("Disabled Sliders") { DisabledSliderExamples() }
            Section("Customized Sliders") { CustomizedSliderExamples() }
        }
    }
}

@Composable
private fun Section(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        BasicText(
            text = title,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        content()
    }
}

// Basic slider example with preset variants
@Composable
private fun BasicSliderExamples() {
    val primaryState = remember { SliderState(0.5f) }
    val secondaryState = remember { SliderState(0.7f) }

    LabeledSlider("Primary Slider (${(primaryState.value * 100).toInt()}%)") {
        BasicSlider(
            state = primaryState,
            colors = SliderPresets.Primary
        )
    }

    LabeledSlider("Secondary Slider (${(secondaryState.value * 100).toInt()}%)") {
        BasicSlider(
            state = secondaryState,
            colors = SliderPresets.Secondary
        )
    }
}

// Range slider example with start and end thumbs
@Composable
private fun RangeSliderExamples() {
    val rangeState = remember { RangeSliderState(0.3f, 0.8f) }

    LabeledSlider("Primary Range Slider") {
        BasicRangeSlider(
            state = rangeState,
            colors = SliderPresets.Primary
        )
    }
}

// Disabled slider examples showing inactive styles
@Composable
private fun DisabledSliderExamples() {
    LabeledSlider("Disabled Primary Slider") {
        BasicSlider(
            state = SliderState(0.5f),
            colors = SliderPresets.Primary,
            enabled = false
        )
    }

    LabeledSlider("Disabled Range Slider") {
        BasicRangeSlider(
            state = RangeSliderState(0.2f, 0.8f),
            colors = SliderPresets.Secondary,
            enabled = false
        )
    }
}

// Examples with custom thumb size, track size, and spacing
@Composable
private fun CustomizedSliderExamples() {
    val customSliderState = remember { SliderState(0.4f) }
    val customRangeState = remember { RangeSliderState(0.2f, 0.7f) }

    LabeledSlider("Custom Thumb and Track Sizes") {
        BasicSlider(
            state = customSliderState,
            colors = SliderPresets.Primary,
            thumbWidth = 28.dp,
            thumbHeight = 28.dp,
            trackHeight = 8.dp,
            thumbTrackGap = 4.dp
        )
    }

    LabeledSlider("Custom Range Slider with Large Thumb") {
        BasicRangeSlider(
            state = customRangeState,
            colors = SliderPresets.Secondary,
            thumbWidth = 32.dp,
            thumbHeight = 32.dp,
            trackHeight = 10.dp,
            thumbTrackGap = 6.dp
        )
    }
}

@Composable
private fun LabeledSlider(label: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        BasicText(
            text = label,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        content()
    }
}
