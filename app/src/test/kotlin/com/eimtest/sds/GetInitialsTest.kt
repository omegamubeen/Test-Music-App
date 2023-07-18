package com.eimtest.sds

import org.junit.Assert.assertEquals
import org.junit.Test

class GetInitialsTest {

    @Test
    fun `test getInitials with two words`() {
        val input = "John Mark"
        val initials = input.getInitials()
        assertEquals("JM", initials)
    }

    @Test
    fun `test getInitials with three words`() {
        val input = "John Mark Doe"
        val initials = input.getInitials()
        assertEquals("JD", initials)
    }

    @Test
    fun `test getInitials with four words`() {
        val input = "John Mark Doe Ben"
        val initials = input.getInitials()
        assertEquals("JB", initials)
    }

    @Test
    fun `test getInitials with single word`() {
        val input = "Alice"
        val initials = input.getInitials()
        assertEquals("AL", initials)
    }

    @Test
    fun `test getInitials with empty string`() {
        val input = ""
        val initials = input.getInitials()
        assertEquals("", initials)
    }

    @Test
    fun `test getInitials with leading and trailing spaces`() {
        val input = "  John  Doe  "
        val initials = input.getInitials()
        assertEquals("JD", initials)
    }

    @Test
    fun `test getInitials with multiple spaces between words`() {
        val input = "John      Doe"
        val initials = input.getInitials()
        assertEquals("JD", initials)
    }

    @Test
    fun `test getInitials with mixed case`() {
        val input = "jOhN dOe"
        val initials = input.getInitials()
        assertEquals("JD", initials)
    }

}

