package org.chornogora.task_8_string_to_integer_atoi;

public class Solution {

    public int myAtoi(String s) {
        s = s.trim();

        if (s.isBlank()) return 0;

        int result = 0;
        boolean signed = s.charAt(0) == '-' || s.charAt(0) == '+';
        boolean positive = s.charAt(0) != '-';

        StringBuilder sb = new StringBuilder();
        for (int i = signed ? 1 : 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c > 48 && c <= 57) || (c == 48 && !sb.isEmpty())) {
                sb.append(c);
            } else if (c != 48) {
                break;
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            int decimals = 1;
            for (int n = i; n < sb.length() - 1; ++n) {
                decimals *= 10;
            }

            int toAdd = (sb.charAt(i) - 48) * decimals;
            if (positive && (result + toAdd < result
                    || decimals == 0
                    || toAdd % decimals != 0
                    || decimals != 1 && decimals % 10 != 0)) {
                result = Integer.MAX_VALUE;
                break;
            } else if (!positive && (result - toAdd > result
                    || decimals == 0
                    || toAdd % decimals != 0
                    || decimals != 1 && decimals % 10 != 0)){
                result = Integer.MIN_VALUE;
                break;
            }
            result = positive ? result + toAdd : result - toAdd;
        }

        return result;
    }
}