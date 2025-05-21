package org.chornogora.task_7_reverse_integer;

public class Solution {

    public int reverse(int x) {
        String intAsString = String.valueOf(x).replaceFirst("0+$", "");
        int result = 0;
        int startWith = x > 0 ? 0 : 1;
        for (int i = startWith; i < intAsString.length(); i++) {
            int decimals = 1;
            for (int n = i; n > startWith; --n) {
                decimals *= 10;
            }

            int calculated = (intAsString.charAt(i) - 48) * decimals;
            int newResult = result + calculated;
            if (newResult < result || calculated % decimals != 0) {
                return 0;
            }
            result = newResult;
        }
        return x > 0 ? result : -result;
    }
}
