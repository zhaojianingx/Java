package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        if (open < n) {
            dfs(n, path + "(", res, open + 1, close);
        }
        if (close < open) {
            dfs(n, path + ")", res, open, close + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(2));
    }
}
