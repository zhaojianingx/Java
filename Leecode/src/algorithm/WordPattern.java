package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        int len = strs.length;
        if (pattern.length() != len) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (!map.containsValue(strs[i])) {
                    map.put(c, strs[i]);
                } else {
                    return false;
                }
            } else if (!map.get(c).equals(strs[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    }
}
