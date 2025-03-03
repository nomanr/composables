package com.nomanr.composables.internal

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween

object MotionSchemeKeyTokens {
    val DefaultSpatial: AnimationSpecToken = AnimationSpecToken()
    val FastEffects: AnimationSpecToken = AnimationSpecToken()
    val DefaultEffect: AnimationSpecToken = AnimationSpecToken()

    class AnimationSpecToken {
        fun value(): FiniteAnimationSpec<Float> {
            return tween(durationMillis = 300, easing = FastOutSlowInEasing)
        }
    }
}