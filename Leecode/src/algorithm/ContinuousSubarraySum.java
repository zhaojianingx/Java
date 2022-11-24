package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int presum = 0;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            int key = k == 0 ? presum : presum % k;
            if (map.containsKey(key)) {
                if (i - map.get(key) >= 2) {
                    return true;
                }
                continue;
            }
            map.put(key, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }
}
