package org.chornogora.task_15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

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

        List<List<Integer>> result = new ArrayList<>();
        if (tokensWithAmount.containsKey(0) && tokensWithAmount.get(0) > 2) {
            result.add(Arrays.asList(0, 0, 0));
        }

        List<Integer> keys = tokensWithAmount.keySet().stream().toList();
        Set<Integer> alreadyFound = new HashSet<>();
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) != 0 && tokensWithAmount.get(keys.get(i)) > 1 && tokensWithAmount.containsKey(-(2 * keys.get(i)))) {
                int hash = calculateHash(keys.get(i), keys.get(i), -(2 * keys.get(i)));
                if (!alreadyFound.contains(hash)) {
                    alreadyFound.add(hash);
                    result.add(Arrays.asList(keys.get(i), keys.get(i), -(2 * keys.get(i))));
                }
            }

            for (int j = i + 1; j < keys.size(); ++j) {
                int diff = -keys.get(i) - keys.get(j);
                if (diff != keys.get(i) && diff != keys.get(j) && tokensWithAmount.containsKey(diff)) {
                    int hash = calculateHash(keys.get(i), keys.get(j), diff);
                    if (!alreadyFound.contains(hash)) {
                        alreadyFound.add(hash);
                        result.add(Arrays.asList(keys.get(i), keys.get(j), diff));
                    }
                }
            }
        }

        System.out.println(System.currentTimeMillis() - time2);

        return result;
    }

    private int calculateHash(int first, int second, int third) {
        List<Integer> sorted = Stream.of(first, second, third).sorted().toList();
        return (sorted.get(0)) + (sorted.get(1)) * 100 + (sorted.get(2)) * 10000;
    }
}