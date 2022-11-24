package algorithm;

/**
 * @author zjn
 **/
public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] hash = new boolean[26];
        int ans = words.length;
        for (char c : allowed.toCharArray()) hash[c - 'a'] = true;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!hash[word.charAt(i) - 'a']) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
