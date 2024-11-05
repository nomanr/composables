package com.nomanr.composables.internal

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.Flow

typealias BackEventCompat = androidx.activity.BackEventCompat

@Composable
internal fun BackHandler(enabled: Boolean, onBack: () -> Unit) {
    androidx.activity.compose.BackHandler(enabled, onBack)
}

@Composable
internal fun PredictiveBackHandler(
    enabled: Boolean, onBack: suspend (progress: Flow<BackEventCompat>) -> Unit
) {
    androidx.activity.compose.PredictiveBackHandler(enabled, onBack)
}

private val PredictiveBackEasing: Easing = CubicBezierEasing(0.1f, 0.1f, 0f, 1f)

internal object PredictiveBack {
    fun transform(progress: Float) = PredictiveBackEasing.transform(progress)
}