package one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        String ans = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0, j = 0;
        int max = Integer.MAX_VALUE;
        int count = map.size();

        while (j <= s.length()) {
            if (count > 0) {
                if (j < s.length() && map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                    if (map.get(s.charAt(j)) == 0) {
                        count--;
                    }
                }
                j++;
            } else {
                if (j - i < max) {
                    max = j - i;
                    ans = s.substring(i, j);
                }
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
