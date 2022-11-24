package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class LowestCommonAncestorOfaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new LowestCommonAncestorOfaBinarySearchTree().lowestCommonAncestor(TreeNode.constructBinaryTree(new int[]{6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5}), TreeNode.constructBinaryTree(new int[]{2}), TreeNode.constructBinaryTree(new int[]{4})).val);
    }
}
