package org.chornogora.task_9_palindrome_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void shouldReturn_true() {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(121);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturn_true2() {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturn_true3() {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(0);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturn_true4() {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(17788771);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturn_true5() {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(1410110141);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturn_false() {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(1432);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturn_false2() {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(Integer.MAX_VALUE);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturn_false3() {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(-1441);
        Assertions.assertFalse(result);
    }
}
