package algorithm;

/**
 * @author zjn
 **/
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        String newStr = new StringBuilder(s).append('#').append(new StringBuilder(s).reverse()).toString();
        int max = getNext(newStr);
        return new StringBuilder(s.substring(max + 1, n)).reverse().append(s).toString();
    }

    private int getNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        int j = -1;
        next[0] = -1;
        for (int i = 1; i < n; i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome("abbacd"));
    }
}
