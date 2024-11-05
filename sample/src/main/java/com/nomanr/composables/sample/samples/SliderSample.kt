package com.nomanr.composables.sample.samples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.nomanr.composables.sample.AppTheme
import com.nomanr.composables.slider.RangeSlider
import com.nomanr.composables.slider.Slider
import com.nomanr.composables.slider.SliderColors

private object SliderPresets {
    val Variant1 = SliderColors(
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

    val Variant2 = SliderColors(
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

    val Variant3 = SliderColors(
        thumbColor = Color(0xFF4CAF50),
        activeTrackColor = Color(0xFF4CAF50),
        activeTickColor = Color(0xFF388E3C),
        inactiveTrackColor = Color(0xFF81C784),
        inactiveTickColor = Color(0xFF81C784).copy(alpha = 0.7f),
        disabledThumbColor = Color(0xFF4CAF50).copy(alpha = 0.38f),
        disabledActiveTrackColor = Color(0xFF4CAF50).copy(alpha = 0.38f),
        disabledActiveTickColor = Color(0xFF388E3C).copy(alpha = 0.38f),
        disabledInactiveTrackColor = Color(0xFF81C784).copy(alpha = 0.38f),
        disabledInactiveTickColor = Color(0xFF81C784).copy(alpha = 0.38f)
    )

    val Variant4 = SliderColors(
        thumbColor = Color(0xFFFFA000),
        activeTrackColor = Color(0xFFFFA000),
        activeTickColor = Color(0xFFFF8F00),
        inactiveTrackColor = Color(0xFFFFCC80),
        inactiveTickColor = Color(0xFFFFCC80).copy(alpha = 0.7f),
        disabledThumbColor = Color(0xFFFFA000).copy(alpha = 0.38f),
        disabledActiveTrackColor = Color(0xFFFFA000).copy(alpha = 0.38f),
        disabledActiveTickColor = Color(0xFFFF8F00).copy(alpha = 0.38f),
        disabledInactiveTrackColor = Color(0xFFFFCC80).copy(alpha = 0.38f),
        disabledInactiveTickColor = Color(0xFFFFCC80).copy(alpha = 0.38f)
    )
}

@Composable
fun SliderSample() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),

    ) {

        SampleSection("Basic Sliders") {
            BasicSliderExamples()
        }

        SampleSection("Custom Styled Sliders") {
            CustomStyledSliderExamples()
        }

        SampleSection("Range Sliders") {
            RangeSliderExamples()
        }

        SampleSection("Stepped Sliders") {
            SteppedSliderExamples()
        }

        SampleSection("Disabled States") {
            DisabledStateExamples()
        }

        SampleSection("Size Variations") {
            SizeVariationExamples()
        }

        SampleSection("Track Corner Variations") {
            TrackCornerExamples()
        }

        SampleSection("Thumb Track Gap Variations") {
            ThumbTrackGapExamples()
        }
    }
}

@Composable
private fun SampleSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.colors.surface, RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        BasicText(
            text = title,
            style = AppTheme.typography.h2
        )
        content()
    }
}

@Composable
private fun BasicSliderExamples() {
    var variant1Value by remember { mutableFloatStateOf(0.5f) }
    var variant2Value by remember { mutableFloatStateOf(0.3f) }
    var variant3Value by remember { mutableFloatStateOf(0.7f) }
    var variant4Value by remember { mutableFloatStateOf(0.4f) }

    LabeledSlider("Variant 1 (${(variant1Value * 100).toInt()}%)") {
        Slider(
            value = variant1Value,
            onValueChange = { variant1Value = it },
            colors = SliderPresets.Variant1
        )
    }

    LabeledSlider("Variant 2 (${(variant2Value * 100).toInt()}%)") {
        Slider(
            value = variant2Value,
            onValueChange = { variant2Value = it },
            colors = SliderPresets.Variant2
        )
    }

    LabeledSlider("Variant 3 (${(variant3Value * 100).toInt()}%)") {
        Slider(
            value = variant3Value,
            onValueChange = { variant3Value = it },
            colors = SliderPresets.Variant3
        )
    }

    LabeledSlider("Variant 4 (${(variant4Value * 100).toInt()}%)") {
        Slider(
            value = variant4Value,
            onValueChange = { variant4Value = it },
            colors = SliderPresets.Variant4
        )
    }
}

@Composable
private fun CustomStyledSliderExamples() {
    var customValue by remember { mutableFloatStateOf(0.5f) }

    LabeledSlider("Tall Track (8dp)") {
        Slider(
            value = customValue,
            onValueChange = { customValue = it },
            colors = SliderPresets.Variant1,
            trackHeight = 8.dp
        )
    }

    LabeledSlider("Large Thumb (28dp)") {
        Slider(
            value = customValue,
            onValueChange = { customValue = it },
            colors = SliderPresets.Variant3,
            thumbWidth = 28.dp,
            thumbHeight = 28.dp
        )
    }

    LabeledSlider("Custom Shape") {
        Slider(
            value = customValue,
            onValueChange = { customValue = it },
            colors = SliderPresets.Variant4,
            thumbShape = RoundedCornerShape(4.dp)
        )
    }
}

@Composable
private fun RangeSliderExamples() {
    var primaryRange by remember { mutableStateOf(0.2f..0.8f) }
    var successRange by remember { mutableStateOf(0.3f..0.7f) }

    LabeledSlider("Basic Range (${(primaryRange.start * 100).toInt()}% - ${(primaryRange.endInclusive * 100).toInt()}%)") {
        RangeSlider(
            value = primaryRange,
            onValueChange = { primaryRange = it },
            colors = SliderPresets.Variant1
        )
    }

    LabeledSlider("Custom Track (${(successRange.start * 100).toInt()}% - ${(successRange.endInclusive * 100).toInt()}%)") {
        RangeSlider(
            value = successRange,
            onValueChange = { successRange = it },
            colors = SliderPresets.Variant3,
            trackHeight = 6.dp,
            thumbTrackGap = 2.dp
        )
    }
}

@Composable
private fun SteppedSliderExamples() {
    var steppedValue by remember { mutableFloatStateOf(0f) }
    var customSteppedRange by remember { mutableStateOf(20f..80f) }

    LabeledSlider("5 Steps (${steppedValue.toInt()}%)") {
        Slider(
            value = steppedValue,
            onValueChange = { steppedValue = it },
            valueRange = 0f..100f,
            steps = 5,
            colors = SliderPresets.Variant1,
            trackTickSize = 6.dp
        )
    }

    LabeledSlider("10 Steps Range (${customSteppedRange.start.toInt()}% - ${customSteppedRange.endInclusive.toInt()}%)") {
        RangeSlider(
            value = customSteppedRange,
            onValueChange = { customSteppedRange = it },
            valueRange = 0f..100f,
            steps = 10,
            colors = SliderPresets.Variant3
        )
    }
}

@Composable
private fun DisabledStateExamples() {
    LabeledSlider("Disabled Basic") {
        Slider(
            value = 0.5f,
            onValueChange = { },
            enabled = false,
            colors = SliderPresets.Variant1
        )
    }

    LabeledSlider("Disabled Range") {
        RangeSlider(
            value = 0.2f..0.8f,
            onValueChange = { },
            enabled = false,
            colors = SliderPresets.Variant2
        )
    }

    LabeledSlider("Disabled with Steps") {
        Slider(
            value = 0.6f,
            onValueChange = { },
            enabled = false,
            steps = 4,
            colors = SliderPresets.Variant4
        )
    }
}

@Composable
private fun TrackCornerExamples() {
    var value by remember { mutableFloatStateOf(0.5f) }

    LabeledSlider("No Corner (0dp)") {
        Slider(
            value = value,
            onValueChange = { value = it },
            colors = SliderPresets.Variant1,
            trackInsideCornerSize = 0.dp
        )
    }

    LabeledSlider("Large Corner (4dp)") {
        Slider(
            value = value,
            onValueChange = { value = it },
            colors = SliderPresets.Variant3,
            trackInsideCornerSize = 4.dp
        )
    }
}

@Composable
private fun ThumbTrackGapExamples() {
    var value by remember { mutableFloatStateOf(0.5f) }

    LabeledSlider("No Gap") {
        Slider(
            value = value,
            onValueChange = { value = it },
            colors = SliderPresets.Variant1,
            thumbTrackGap = 0.dp
        )
    }

    LabeledSlider("Small Gap (2dp)") {
        Slider(
            value = value,
            onValueChange = { value = it },
            colors = SliderPresets.Variant4,
            thumbTrackGap = 2.dp
        )
    }

    LabeledSlider("Large Gap (4dp)") {
        Slider(
            value = value,
            onValueChange = { value = it },
            colors = SliderPresets.Variant2,
            thumbTrackGap = 4.dp
        )
    }

    LabeledSlider("Material Style") {
        Slider(
            value = value,
            onValueChange = { value = it },
            colors = SliderPresets.Variant2,
            thumbTrackGap = 4.dp,
            thumbSizeOnPress = DpSize(12.dp, 24.dp),
            trackHeight = 8.dp
        )
    }
}

@Composable
private fun SizeVariationExamples() {
    var value by remember { mutableFloatStateOf(0.5f) }

    LabeledSlider("Extra Large Thumb") {
        Slider(
            value = value,
            onValueChange = { value = it },
            colors = SliderPresets.Variant1,
            thumbWidth = 32.dp,
            thumbHeight = 32.dp,
            thumbSizeOnPress = DpSize(36.dp, 36.dp),
        )
    }

    LabeledSlider("Extra Thick Track") {
        Slider(
            value = value,
            onValueChange = { value = it },
            colors = SliderPresets.Variant3,
            trackHeight = 12.dp,
            thumbTrackGap = 2.dp
        )
    }
}

@Composable
private fun LabeledSlider(
    label: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        BasicText(
            text = label,
            style = AppTheme.typography.subtitle,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        content()
    }
}
