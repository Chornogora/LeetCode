package org.chornogora.task_9_palindrome_number;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int length = getNumberLength(x);
        for (int i = 0; i < length / 2; i++) {
            int first = (length == 10 && i == 0)
                    ? x / 10 % pow(10, 9) / pow(10, 8)
                    : x % pow(10, length - i) / pow(10, length - i - 1);
            int second = x / pow(10, i) % pow(10, 1);
            if (first != second) {
                return false;
            }
        }
        return true;
    }

    private int getNumberLength(int x) {
        int n = 1;
        for (int i = 10; i <= 1000000000; i *= 10) {
            if (x % i == x) {
                return n;
            }
            ++n;
        }
        return 10;
    }

    private int pow(int x, int power) {
        if (power == 0) {
            return 1;
        }
        for (int i = 1; i < power; i++) {
            x = x * 10;
        }
        return x;
    }
}