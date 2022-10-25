package com.stefanus.noteapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * tes aplikasi, yang akan dijalankan pada device android.
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // konteks aplikasi yang sedang dijalankan
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.stefanus.noteapp", appContext.packageName)
    }
}