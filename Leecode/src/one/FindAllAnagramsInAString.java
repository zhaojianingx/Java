package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zjn
 **/
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] a = new int[26];
        for (char c : p.toCharArray()) {
            a[c - 'a']++;
        }
        int[] b = new int[26];
        for (int l = 0, r = 0; r  < s.length(); r++) {
            b[s.charAt(r) - 'a']++;
            if (r - l + 1 == p.length()) {
                if (Arrays.equals(a, b)) res.add(l);
                b[s.charAt(l++) - 'a']--;
            }
        }
        return res;
    }
}
