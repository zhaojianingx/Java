package algorithm;

/**
 * @author zjn
 **/
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int cur = 0, ans = 0;
        for (int x : gain) {
            cur += x;
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheHighestAltitude().largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }
}
