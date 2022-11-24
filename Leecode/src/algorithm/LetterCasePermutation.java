package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class LetterCasePermutation {
    char[] cs;
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        cs = s.toCharArray();
        dfs(0, s.length(), new char[s.length()]);
        return ans;
    }

    private void dfs(int index, int n, char[] cur) {
        if (index == n) {
            ans.add(String.valueOf(cur));
            return;
        }
        cur[index] = cs[index];
        dfs(index + 1, n, cur);
        if (Character.isLetter(cs[index])) {
            cur[index] = (char) (cs[index] ^ 32);
            dfs(index + 1, n, cur);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("3z4"));
    }
}
