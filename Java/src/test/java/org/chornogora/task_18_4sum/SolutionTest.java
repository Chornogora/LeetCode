package org.chornogora.task_18_4sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void shouldReturn_3() {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void shouldReturn_1() {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(new int[]{2,2,2,2,2}, 8);
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void shouldReturn_2() {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void shouldReturn_0() {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        Assertions.assertEquals(0, result.size());
    }
}
