package one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new IntersectionOfTwoArraysII().intersect(new int[]{1, 2, 2, 1}, new int[]{2})));
    }
}
