package org.chornogora.task_1_two_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void shouldReturn_0_1() {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{11, 2, 7, 15}, 9);
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);
    }
}