package com.mobilesolutionworks.android.bolts

import bolts.Task

fun <T> Task<T>.subscribe(onNext: (T) -> Unit) {
    subscribe(onNext, {}, {})
}

fun <T> Task<T>.subscribe(onNext: (T) -> Unit, onError: (Task<T>) -> Unit = {}, onCancel: (Task<T>) -> Unit = {}) {
    this.continueWith {
        when {
            it.isCompleted && !it.isFaulted && !it.isCancelled -> onNext(it.result)
            it.isFaulted -> onError(it)
            it.isCancelled -> onCancel(it)
        }
    }
}