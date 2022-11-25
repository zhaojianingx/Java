package algorithm;

/**
 * @author zjn
 **/
public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        char[] str = s.toCharArray();
        int ans = 0;
        for (String word : words) {
            if (isExpressive(str, word.toCharArray())) ans++;
        }
        return ans;
    }

    private boolean isExpressive(char[] s, char[] word) {
        int m = word.length, n = s.length;
        if (m > n) return false;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s[i] != word[j]) {
                return false;
            }
            int cntI = 1, cntJ = 1;
            i++; j++;
            while (i < n && s[i] == s[i - 1]) {
                cntI++;
                i++;
            }
            while (j < m && word[j] == word[j - 1]) {
                cntJ++;
                j++;
            }
            if (cntI < cntJ || ((cntI > cntJ) && cntI < 3)) return false;
        }
        return i == n && j == m;
    }

    public static void main(String[] args) {
        System.out.println(new ExpressiveWords().expressiveWords("abcd", new String[]{"abc"}));
    }
}
