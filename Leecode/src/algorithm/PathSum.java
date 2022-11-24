package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetSum);
            if (left) {
                return true;
            }
        }
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetSum);
            if (right) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PathSum().hasPathSum(TreeNode.constructBinaryTree(new int[]{1, 4, 5}), 3));
    }
}
