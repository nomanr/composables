package com.nomanr.composables.bottomsheet

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Immutable
actual class ModalBottomSheetProperties actual constructor(
    actual val shouldDismissOnBackPress: Boolean,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ModalBottomSheetProperties) return false

        return true
    }

    override fun hashCode(): Int {
        var result = shouldDismissOnBackPress.hashCode()
        return result
    }

}

@Immutable
actual object ModalBottomSheetDefaults {
    actual val properties = ModalBottomSheetProperties()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal actual fun ModalBottomSheetDialog(
    onDismissRequest: () -> Unit,
    properties: ModalBottomSheetProperties,
    predictiveBackProgress: Animatable<Float, AnimationVector1D>,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            dismissOnBackPress = properties.shouldDismissOnBackPress,
            usePlatformDefaultWidth = false,
            usePlatformInsets = false,
            scrimColor = Color.Transparent,
        ),
        content = content
    )
}