package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjn
 **/
public class IncreasingSubsequences {
    // 结果集合
    List<List<Integer>> res = new ArrayList<>();
    // 路径集合
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        getSubsequences(nums, 0);
        return res;
    }

    private void getSubsequences(int[] nums, int startIndex) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            // 使用过了当前数字
            if (map.getOrDefault(nums[i], 0) >= 1) {
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            path.add(nums[i]);
            getSubsequences(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingSubsequences().findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
