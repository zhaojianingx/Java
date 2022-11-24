package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class SearchInABinarySearchTree {
    // 迭代法
    public TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
    // 迭代法
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST2(root.left, val);
        } else {
            return searchBST2(root.right, val);
        }
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.LevelOrderTraversal(new SearchInABinarySearchTree().searchBST2(TreeNode.constructBinaryTree(new int[]{4, 2, 7, 1, 3}), 2)));
    }
}
