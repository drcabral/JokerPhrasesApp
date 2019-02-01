package com.diogocabral.viperSampleApp.extensions

import com.diogocabral.viperSampleApp.entity.utils.getRandomElement
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ListExtensionsTest {

    private lateinit var list: List<String>

    @Before
    fun setup(){
        list = listOf()
    }

    @Test
    fun getRandomElementShouldReturnNullIfThereIsNoOneElement() {
        assertEquals(null, list.getRandomElement())
    }

    @Test
    fun getRandomElementShouldReturnStringIfThereIsElements() {
        list = listOf("foo")
        assertEquals("foo", list.getRandomElement())
    }
}
