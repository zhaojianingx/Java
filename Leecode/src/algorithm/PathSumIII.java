package algorithm;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, map, targetSum, 0);
    }

    private int dfs(TreeNode root, Map<Long, Integer> preSum2CountMap, int targetSum, long preSum) {
        if (root == null) return 0;
        preSum += root.val;

        int ans = preSum2CountMap.getOrDefault(preSum - targetSum, 0);

        preSum2CountMap.put(preSum, preSum2CountMap.getOrDefault(preSum, 0) + 1);

        ans += dfs(root.left, preSum2CountMap, targetSum, preSum);
        ans += dfs(root.right, preSum2CountMap, targetSum, preSum);

        preSum2CountMap.put(preSum, preSum2CountMap.get(preSum) - 1);
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new PathSumIII().pathSum(TreeNode.constructBinaryTree(new int[]{10,5,-3,3,2,-1,11,3,-2,-1,1}), 8));
    }
}
