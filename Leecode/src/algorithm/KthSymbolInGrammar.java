package algorithm;

/**
 * @author zjn
 **/
public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        return dfs(n, k, 1) == 0 ? 1 : 0;
    }

    private int dfs(int r, int c, int cur) {
        if (r == 1) return cur;
        if ((c % 2 == 0 && cur == 0) || (c % 2 == 1 && cur == 1)) {
            return dfs(r - 1, (c - 1) / 2 + 1, 1);
        } else return dfs(r - 1, (c - 1) / 2 + 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(new KthSymbolInGrammar().kthGrammar(2, 1));
    }
}
