package algorithm;

import one.MinimumWindowSubstring;

/**
 * @author zjn
 **/
public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        int cnt = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            cnt += (s.charAt(i) - '0') ^ (i & 1);
        }
        return Math.min(cnt, n - cnt);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumChangesToMakeAlternatingBinaryString().minOperations("10010100"));
    }
}
