package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                start++;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new AssignCookies().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }
}
