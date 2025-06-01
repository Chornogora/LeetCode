package org.chornogora.task_16_3sum_closest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {

        long time = System.currentTimeMillis();

        Map<Integer, Integer> tokensWithAmount = new HashMap<>();
        for (int num : nums) {
            if (tokensWithAmount.containsKey(num)) {
                tokensWithAmount.put(num, tokensWithAmount.get(num) + 1);
            } else {
                tokensWithAmount.put(num, 1);
            }
        }

        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);

        Integer result = null;
        List<Integer> keys = tokensWithAmount.keySet().stream().sorted().toList();
        int newSize = 0;
        for (Integer key : keys) {
            for (int i = 0; i < tokensWithAmount.get(key); i++) {
                nums[newSize++] = key;
            }
        }

        long time3 = System.currentTimeMillis();
        System.out.println(time3 - time2);

        for (int i = 0; i < newSize; i++) {
            for (int j = i + 1; j < newSize; j++) {
                for (int k = j + 1; k < newSize; k++) {
                    int sum = (nums[i] + nums[j] + nums[k]);
                    if ( result == null || Math.abs(target - sum) < Math.abs(target - result)) {
                        result = sum;
                    }
                }
            }
        }

        System.out.println(System.currentTimeMillis() - time3);

        return result;
    }
}