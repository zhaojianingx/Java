package algorithm;

import structure.TreeNode;

import java.util.*;

/**
 * @author zjn
 **/
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) return list;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peekFirst();
                levelList.add(Objects.requireNonNull(queue.pollFirst()).val);

                if (peek.left != null) {
                    queue.offerLast(peek.left);
                }
                if (peek.right != null) {
                    queue.offerLast(peek.right);
                }
            }
            list.add(levelList);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeLevelOrderTraversalII().levelOrderBottom(TreeNode.constructBinaryTree(new int[]{3, 9, 20, -1, -1, 15, 7})));
    }
}
