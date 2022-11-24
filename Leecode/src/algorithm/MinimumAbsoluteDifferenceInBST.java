package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class MinimumAbsoluteDifferenceInBST {
    TreeNode pre; // 记录上一个遍历的节点
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        // 左
        traversal(root.left);
        // 中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        // 右
        traversal(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(TreeNode.constructBinaryTree(new int[]{4, 2, 6, 1, 3})));
    }
}
