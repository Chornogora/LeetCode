package org.chornogora.task_7_reverse_integer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void shouldReturn_321() {
        Solution solution = new Solution();
        int result = solution.reverse(123);
        Assertions.assertEquals(321, result);
    }

    @Test
    public void shouldReturn_minus_321() {
        Solution solution = new Solution();
        int result = solution.reverse(-123);
        Assertions.assertEquals(-321, result);
    }

    @Test
    public void shouldReturn_21() {
        Solution solution = new Solution();
        int result = solution.reverse(120);
        Assertions.assertEquals(21, result);
    }

    @Test
    public void shouldReturn_minus_21() {
        Solution solution = new Solution();
        int result = solution.reverse(-120);
        Assertions.assertEquals(-21, result);
    }

    @Test
    public void shouldReturn_0() {
        Solution solution = new Solution();
        int result = solution.reverse(Integer.MAX_VALUE);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void shouldAlsoReturn_0() {
        Solution solution = new Solution();
        int result = solution.reverse(1534236469);
        Assertions.assertEquals(0, result);
    }

}
