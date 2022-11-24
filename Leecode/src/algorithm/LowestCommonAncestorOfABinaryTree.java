package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 后续遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            // 若未找到节点p或q
            return null;
        } else if (left == null && right != null) {
            // 若找到一个节点
            return right;
        } else if (left != null && right == null) {
            // 若找到一个节点
            return left;
        } else {
            // 若找到两个节点
            return root;
        }
    }
}
