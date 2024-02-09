package org.chornogora.task_1_two_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elementToItsIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (elementToItsIndexMap.get(diff) != null) {
                return new int[]{elementToItsIndexMap.get(diff), i};
            }
            elementToItsIndexMap.put(nums[i], i);
        }
        return new int[0];
    }
}