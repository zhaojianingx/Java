package algorithm;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjn
 **/
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(TreeNode.constructBinaryTree(new int[]{3, 9, 20, -1, -1, 15, 7})));
    }
}
