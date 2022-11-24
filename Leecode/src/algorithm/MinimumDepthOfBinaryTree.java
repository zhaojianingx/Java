package algorithm;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjn
 **/
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            TreeNode cur = null;
            while (size-- > 0) {
                cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(TreeNode.constructBinaryTree(new int[]{3, 9, 20, -1, -1, 15, 7})));
    }
}
