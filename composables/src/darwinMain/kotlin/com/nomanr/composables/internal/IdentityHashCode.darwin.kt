package com.nomanr.composables.internal

internal actual fun identityHashCode(instance: Any?): Int {
    return instance?.hashCode() ?: 0
}