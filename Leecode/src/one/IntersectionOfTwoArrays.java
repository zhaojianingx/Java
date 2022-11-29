package one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zjn
 **/
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        return res.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().intersection(new int[]{1, 2, 2, 1}, new int[]{2})));
    }
}
