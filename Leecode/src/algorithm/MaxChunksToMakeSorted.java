package algorithm;

/**
 * @author zjn
 **/
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int max = 0, ans = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}
