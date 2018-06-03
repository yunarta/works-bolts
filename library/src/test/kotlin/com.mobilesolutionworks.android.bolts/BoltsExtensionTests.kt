package com.mobilesolutionworks.android.bolts

import bolts.TaskCompletionSource
import junit.framework.Assert.*
import org.junit.Test

class BoltsExtensionTests {

    @Test
    fun testWithSubscribe() {
        val completionSource = TaskCompletionSource<String>()
        completionSource.setResult("text")
        completionSource.task.subscribe {
            assertEquals("text", it)
        }
    }

    @Test
    fun testWithSubscribeError() {
        val completionSource = TaskCompletionSource<String>()
        completionSource.setError(RuntimeException())
        completionSource.task.subscribe(onNext = {
            fail()
        }, onError = {
            assertTrue(it.isFaulted)
            assertNotNull(it.error)
        })
    }

    @Test
    fun testWithSubscribeCancel() {
        val completionSource = TaskCompletionSource<String>()
        completionSource.setCancelled()
        completionSource.task.subscribe(onNext = {
            fail()
        }, onError = {
            fail()
        }, onCancel = {
            assertTrue(it.isCancelled)
        })
    }

}