package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjn
 **/
public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) set.add(c);
        int n = s.length(), cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(s.charAt(i))) continue;
            cnt += i < n / 2 ? 1 : -1;
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(new DetermineIfStringHalvesAreAlike().halvesAreAlike("book"));
    }
}
