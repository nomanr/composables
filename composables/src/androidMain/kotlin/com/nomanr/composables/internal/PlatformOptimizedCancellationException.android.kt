package com.nomanr.composables.internal

import kotlinx.coroutines.CancellationException

/**
 * Represents a platform-optimized cancellation exception.
 * This allows us to configure exceptions separately on JVM and other platforms.
 */
internal actual abstract class PlatformOptimizedCancellationException actual constructor(message: String?) :
    CancellationException()