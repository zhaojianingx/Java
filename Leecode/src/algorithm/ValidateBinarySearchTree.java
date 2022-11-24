package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class ValidateBinarySearchTree {
    private boolean flag = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null && root.val <= prev.val) {
            flag = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new ValidateBinarySearchTree().isValidBST(TreeNode.constructBinaryTree(new int[]{2, 1, 3})));
    }
}
