package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            ans += map.getOrDefault(sum + nums[i] - goal, 0);
            sum += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
