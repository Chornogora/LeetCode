package org.chornogora.task_18_4sum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        TreeMap<Integer, Integer> tokensWithAmount = new TreeMap<>();
        for (int num : nums) {
            if (tokensWithAmount.containsKey(num)) {
                tokensWithAmount.put(num, tokensWithAmount.get(num) + 1);
            } else {
                tokensWithAmount.put(num, 1);
            }
        }

        List<List<BigDecimal>> result = solve(tokensWithAmount, 4, new BigDecimal(target));
        return result.stream()
                .map(list -> list.stream().map(BigDecimal::intValue).toList())
                .toList();
    }

    private List<List<BigDecimal>> solve(NavigableMap<Integer, Integer> tokensWithAmount, int numberInArray, BigDecimal target) {
        if (numberInArray == 0) {
            return new ArrayList<>();
        } else if (numberInArray == 1) {
            return tokensWithAmount.containsKey(target.intValue())
                    ? Collections.singletonList(Collections.singletonList(target))
                    : new ArrayList<>();
        } else {
            List<Integer> keys = tokensWithAmount.keySet().stream().toList();
            List<List<BigDecimal>> result = new ArrayList<>();
            for (int key : keys) {
                int amount = tokensWithAmount.get(key);
                for (int i = Math.min(amount, numberInArray); i > 0; --i) {
                    List<BigDecimal> tempResult = new ArrayList<>();
                    IntStream.range(0, i).forEach(index -> tempResult.add(new BigDecimal(key)));
                    BigDecimal sum = tempResult.stream().reduce(new BigDecimal(0), BigDecimal::add);

                    if (i == numberInArray && sum.equals(target)) {
                        result.add(tempResult);
                        continue;
                    }

                    List<List<BigDecimal>> subResults = solve(
                            tokensWithAmount.tailMap(key, false),
                            numberInArray - i,
                            target.subtract(sum)
                    );
                    subResults.forEach(sublist -> {
                        List<BigDecimal> resultPart = new ArrayList<>(sublist);
                        resultPart.addAll(tempResult);
                        result.add(resultPart);
                    });
                }
            }
            return result;
        }
    }
}