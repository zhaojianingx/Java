package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        int lmr = root.val + Math.max(0, left) + Math.max(0, right);
        res = Math.max(res, lmr);
        return Math.max(left, Math.max(right, 0)) + root.val;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(TreeNode.constructBinaryTree(new int[]{-3})));
    }
}
