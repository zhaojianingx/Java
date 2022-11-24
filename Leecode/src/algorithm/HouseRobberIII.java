package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robAction(TreeNode root) {
        int res[] = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        // 不偷该节点
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷该节点
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberIII().rob(TreeNode.constructBinaryTree(new int[]{3, 2, 3, -1, 3, -1, 1})));
    }
}
