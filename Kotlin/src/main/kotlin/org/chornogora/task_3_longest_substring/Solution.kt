package org.chornogora.task_3_longest_substring

import kotlin.math.max

class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        var result = -1
        val charToIndexMap = hashMapOf<Char, Int>()
        var sequenceStart = 0
        s.forEachIndexed{ i, ch ->
            val prev = charToIndexMap[ch]
            sequenceStart = max(sequenceStart, (prev ?: -1) + 1)
            result = max(i + 1 - sequenceStart, result)
            charToIndexMap[ch] = i
        }
        return if (s.isEmpty()) 0 else result
    }
}
