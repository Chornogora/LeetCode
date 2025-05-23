package org.chornogora.task_8_string_to_integer_atoi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void shouldReturn_42() {
        Solution solution = new Solution();
        int result = solution.myAtoi("42");
        Assertions.assertEquals(42, result);
    }

    @Test
    public void shouldReturn_minus_42() {
        Solution solution = new Solution();
        int result = solution.myAtoi(" -042");
        Assertions.assertEquals(-42, result);
    }

    @Test
    public void shouldReturn_1337() {
        Solution solution = new Solution();
        int result = solution.myAtoi("1337c0d3");
        Assertions.assertEquals(1337, result);
    }

    @Test
    public void shouldReturn_min_integer() {
        Solution solution = new Solution();
        int result = solution.myAtoi("-91283472332");
        Assertions.assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void shouldReturn_max_integer() {
        Solution solution = new Solution();
        int result = solution.myAtoi("21474836460");
        Assertions.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void shouldAlsoReturn_max_integer() {
        Solution solution = new Solution();
        int result = solution.myAtoi("    10522545459");
        Assertions.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void shouldAlsoReturn_max_integer2() {
        Solution solution = new Solution();
        int result = solution.myAtoi("1234567890123456789012345678901234567890");
        Assertions.assertEquals(Integer.MAX_VALUE, result);
    }

}
