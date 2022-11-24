package algorithm;

/**
 * @author zjn
 **/
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]表示最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 倒叙遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i- zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new OnesAndZeroes().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
