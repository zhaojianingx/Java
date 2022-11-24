package algorithm;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }
        // 前闭后开
        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }
        int rootIndex = map.get(preorder[preBegin]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1,
                inorder, inBegin, rootIndex);
        root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd,
                inorder, rootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.LevelOrderTraversal(new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})));
    }
}
