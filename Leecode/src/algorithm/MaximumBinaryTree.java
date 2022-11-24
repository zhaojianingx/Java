package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            // 没有元素了
            return null;
        }
        if (rightIndex - leftIndex == 1) {
            // 只有一个元素
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = leftIndex; // 最大值所在位置
        int maxVal = nums[maxIndex]; // 最大值
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.LevelOrderTraversal(new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5})));
    }
}
