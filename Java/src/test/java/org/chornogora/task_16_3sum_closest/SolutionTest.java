package org.chornogora.task_16_3sum_closest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void shouldReturn_2() {
        Solution solution = new Solution();
        int result = solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void shouldReturn_0() {
        Solution solution = new Solution();
        int result = solution.threeSumClosest(new int[]{0, 0, 0}, 1);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void shouldReturn_60() {
        Solution solution = new Solution();
        int result = solution.threeSumClosest(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 1);
        Assertions.assertEquals(60, result);
    }
}
