package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, ans = 0;
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            ans += map.getOrDefault(sum + nums[i - 1] - k, 0);
            sum += nums[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1, 1, 1, 1, -1, 1, 1}, 2));
    }
}
