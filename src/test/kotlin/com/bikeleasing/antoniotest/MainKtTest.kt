package com.bikeleasing.antoniotest

import com.bikeleasing.antoniotest.utils.readPositionsFromStdIn
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun `readlnOrNull returns null when input is empty`() {
        // Act
        val result = readPositionsFromStdIn()
        // Assert
        assertEquals(null, result)
    }

}