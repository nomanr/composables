package com.nomanr.composables.internal

import kotlinx.coroutines.CancellationException

/**
 * Represents a platform-optimized cancellation exception.
 * This allows us to configure exceptions separately on JVM and other platforms.
 */
internal expect abstract class PlatformOptimizedCancellationException(
    message: String? = null
) : CancellationException