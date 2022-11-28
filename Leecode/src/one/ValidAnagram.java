package one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjn
 **/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
            record[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }
}
