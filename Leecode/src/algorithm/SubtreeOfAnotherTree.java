package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSub(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSub(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val != subRoot.val) return false;
        return isSub(root.left, subRoot.left) && isSub(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        System.out.println(new SubtreeOfAnotherTree().isSubtree(TreeNode.constructBinaryTree(new int[]{3, 4, 5, 1, 2, -1, -1, -1, -1, 0}), TreeNode.constructBinaryTree(new int[]{4, 1, 2})));
    }
}
