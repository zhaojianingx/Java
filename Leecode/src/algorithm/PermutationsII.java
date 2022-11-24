package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zjn
 **/
public class PermutationsII {
    // 存放结果
    List<List<Integer>> result = new ArrayList<>();
    // 暂存结果
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果同一树层nums[i-1]使用过则直接跳过
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            // 如果同一树枝nums[i]没使用过则开始处理
            if (used[i] == false) {
                used[i] = true; // 标记同一树枝nums[i]使用过，防止同一树枝重复使用
                path.add(nums[i]);
                backTrack(nums, used);
                path.remove(path.size() - 1); // 回溯，说明同一树层nums[i]使用过，防止下一树层重复
                used[i] = false; // 回溯
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{1, 1, 2}));
    }
}
