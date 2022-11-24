package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new CountCompleteTreeNodes().countNodes(TreeNode.constructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, -1})));
    }
}
