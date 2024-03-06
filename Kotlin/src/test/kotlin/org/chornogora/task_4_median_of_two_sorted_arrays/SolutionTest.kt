package org.chornogora.task_4_median_of_two_sorted_arrays

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

    val solution: Solution = Solution()

    @Test
    fun shouldReturnMiddleElementOfFirstArray() {
        val result = solution.findMedianSortedArrays(IntArray(3) { it }, intArrayOf())
        Assertions.assertEquals(1.0, result)
    }

    @Test
    fun shouldReturnMedianOfSecondArray() {
        val result = solution.findMedianSortedArrays(intArrayOf(), intArrayOf(4, 5, 6, 7))
        Assertions.assertEquals(5.5, result)
    }

    @Test
    fun shouldReturnMedianUsingOnlySecondArray() {
        val result = solution.findMedianSortedArrays(intArrayOf(1), intArrayOf(2, 5, 6, 7))
        Assertions.assertEquals(5.0, result)
    }

    @Test
    fun shouldReturnMedianUsingOnlyFirstArray() {
        val result = solution.findMedianSortedArrays(intArrayOf(1, 2, 3), intArrayOf(6, 7))
        Assertions.assertEquals(3.0, result)
    }

    @Test
    fun shouldReturnMedianUsingBothArrays() {
        val result = solution.findMedianSortedArrays(intArrayOf(1, 3, 4, 12, 18), intArrayOf(2, 6, 7, 8, 9, 16))
        Assertions.assertEquals(7.0, result)
    }

    @Test
    fun shouldReturnMedianUsingBothArraysOfTheSameSize() {
        val result = solution.findMedianSortedArrays(intArrayOf(1, 3, 4, 12, 18, 20), intArrayOf(2, 6, 7, 8, 9, 16))
        Assertions.assertEquals(7.5, result)
    }
}
