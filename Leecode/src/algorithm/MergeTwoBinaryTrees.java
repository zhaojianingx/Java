package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.LevelOrderTraversal(new MergeTwoBinaryTrees().mergeTrees(TreeNode.constructBinaryTree(new int[]{1, 3, 2, 5, -1}), TreeNode.constructBinaryTree(new int[]{2, 1, 3, -1, 4, -1, 7}))));
    }
}
