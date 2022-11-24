package algorithm;

/**
 * @author zjn
 **/
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length, noSwap = 0, swap = 1;
        for (int i = 1; i < n; i++) {
            int ns = n, s= n; // 答案不会超过n,故初始化成n,方便后面取min
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                ns = noSwap;
                s = swap + 1;
            }
            if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
                ns = Math.min(ns, swap);
                s = Math.min(s, noSwap + 1);
            }
            noSwap = ns;
            swap = s;
        }
        return Math.min(noSwap, swap);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSwapsToMakeSequencesIncreasing().minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
    }
}
