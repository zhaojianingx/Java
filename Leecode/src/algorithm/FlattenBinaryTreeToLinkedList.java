package algorithm;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    private void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    public static void main(String[] args) {
        new FlattenBinaryTreeToLinkedList().flatten(TreeNode.constructBinaryTree(new int[]{1, 2, 5, 3, 4, -1, 6}));
    }
}
