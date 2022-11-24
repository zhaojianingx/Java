package algorithm;

import java.util.HashSet;

/**
 * @author zjn
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int stablePointer = 0;
        int unstablePointer = 0;
        int maxLength = 0;
        while (unstablePointer < s.length()) {
            if (!set.contains(s.charAt(unstablePointer))) {
                set.add(s.charAt(unstablePointer));
                unstablePointer++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(stablePointer));
                stablePointer++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
}
