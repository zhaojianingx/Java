package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> availableMap = new HashMap<>();
        Map<Integer, Integer> wantMap = new HashMap<>();
        for (int i : nums) {
            availableMap.put(i, availableMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (availableMap.get(nums[i]) <= 0) {
                continue;
            } else if (wantMap.getOrDefault(nums[i], 0) > 0) {
                availableMap.put(nums[i], availableMap.getOrDefault(nums[i], 0) - 1);
                wantMap.put(nums[i], wantMap.getOrDefault(nums[i], 0) - 1);
                wantMap.put(nums[i] + 1, wantMap.getOrDefault(nums[i] + 1, 0) + 1);
            } else if (availableMap.getOrDefault(nums[i],0) > 0 && availableMap.getOrDefault(nums[i] + 1,0) > 0 && availableMap.getOrDefault(nums[i] + 2,0) > 0) {
                availableMap.put(nums[i], availableMap.getOrDefault(nums[i],0) - 1);
                availableMap.put(nums[i] + 1, availableMap.getOrDefault(nums[i]+1,0) - 1);
                availableMap.put(nums[i] + 2, availableMap.getOrDefault(nums[i]+2,0) - 1);

                wantMap.put(nums[i] + 3, wantMap.getOrDefault(nums[i] + 3,0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayIntoConsecutiveSubsequences().isPossible(new int[]{1, 2, 3, 3, 4, 5}));
    }
}
