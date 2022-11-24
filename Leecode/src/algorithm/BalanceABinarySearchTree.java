package algorithm;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class BalanceABinarySearchTree {
    List<Integer> res = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        traversal(root);
        return getTree(res, 0, res.size() - 1);
    }

    // 有序树转成有序数组
    private void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);
        res.add(cur.val);
        traversal(cur.right);
    }

    // 将有序数组转成平衡二叉树
    private TreeNode getTree(List<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = getTree(nums, left, mid - 1);
        root.right = getTree(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.LevelOrderTraversal(new BalanceABinarySearchTree().balanceBST(TreeNode.constructBinaryTree(new int[]{1, -1, 2, -1, -1, -1, 3}))));
    }
}
