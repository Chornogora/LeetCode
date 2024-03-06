package org.chornogora.task_4_median_of_two_sorted_arrays

import kotlin.math.floor

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val terminalIndex = floor(((nums1.size + nums2.size).toDouble() / 2)).toInt()

        if (nums1.isEmpty()) {
            return medianOfSimpleArray(nums2, terminalIndex)
        } else if (nums2.isEmpty()) {
            return medianOfSimpleArray(nums1, terminalIndex)
        }

        var nums1Index = 0
        var nums2Index = 0
        var prevValue = Int.MIN_VALUE
        var currValue = Int.MIN_VALUE
        for (i in 0..<terminalIndex + 1) {
            if (nums1Index == nums1.size) {
                prevValue = currValue
                currValue = nums2[nums2Index]
                ++nums2Index
                continue
            } else if (nums2Index == nums2.size) {
                prevValue = currValue
                currValue = nums1[nums1Index]
                ++nums1Index
                continue
            }

            if (nums1[nums1Index] < nums2[nums2Index]) {
                prevValue = currValue
                currValue = nums1[nums1Index]
                ++nums1Index
            } else {
                prevValue = currValue
                currValue = nums2[nums2Index]
                ++nums2Index
            }
        }


        return if ((nums1.size + nums2.size) % 2 == 1) currValue.toDouble() else (prevValue + currValue).toDouble() / 2
    }

    private fun medianOfSimpleArray(nums: IntArray, terminalIndex: Int): Double {
        return if (nums.size % 2 == 0)
            (nums[terminalIndex - 1] + nums[terminalIndex]).toDouble() / 2
        else
            nums[terminalIndex].toDouble()
    }
}
