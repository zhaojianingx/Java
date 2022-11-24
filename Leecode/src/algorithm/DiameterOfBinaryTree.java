package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(TreeNode.constructBinaryTree(new int[]{1, 2, 3, 4, 5})));
    }
}
