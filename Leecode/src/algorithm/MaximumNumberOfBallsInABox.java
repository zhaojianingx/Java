package algorithm;

/**
 * @author zjn
 **/
public class MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        int[] cnt = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            int j = i, cur = 0;
            while (j != 0) {
                cur += j % 10;
                j /= 10;
            }
            if (++cnt[cur] > ans) ans = cnt[cur];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfBallsInABox().countBalls(1, 10));
    }
}
