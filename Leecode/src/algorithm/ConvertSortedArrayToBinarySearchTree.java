package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helpBinaryTreeBuilder(nums, 0, nums.length - 1);
    }

    private TreeNode helpBinaryTreeBuilder(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helpBinaryTreeBuilder(nums, left, mid - 1);
        root.right = helpBinaryTreeBuilder(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.LevelOrderTraversal(new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})));
    }
}
