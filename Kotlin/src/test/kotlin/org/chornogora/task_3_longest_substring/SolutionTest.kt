package org.chornogora.task_3_longest_substring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SolutionTest {

    private val solution = Solution()

    @Test
    fun shouldReturnZeroWhenEmptyLineProvided() {
        val result = solution.lengthOfLongestSubstring("")
        assertEquals(0, result)
    }

    @Test
    fun shouldReturnThree() {
        val result = solution.lengthOfLongestSubstring("abcabcbb")
        assertEquals(3, result)
    }

    @Test
    fun shouldReturnThreeAsWell() {
        val result = solution.lengthOfLongestSubstring("pwwkew")
        assertEquals(3, result)
    }

    @Test
    fun shouldReturnThreeToo() {
        val result = solution.lengthOfLongestSubstring("dvdf")
        assertEquals(3, result)
    }

    @Test
    fun shouldReturnTwo() {
        val result = solution.lengthOfLongestSubstring("abba")
        assertEquals(2, result)
    }

    @Test
    fun shouldReturnSeven() {
        val result = solution.lengthOfLongestSubstring("vbxpvwkkteaiob")
        assertEquals(7, result)
    }

    @Test
    fun shouldReturnOneForSimilarSymbols() {
        val result = solution.lengthOfLongestSubstring("bbbbb")
        assertEquals(1, result)
    }
}