package algorithm;

/**
 * @author zjn
 **/
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        // dp[i]表示1到i为节点组成的二叉搜索树的个数为dp[i]
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
    }
}
