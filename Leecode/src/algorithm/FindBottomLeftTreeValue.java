package algorithm;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjn
 **/
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue(TreeNode.constructBinaryTree(new int[]{2, 1, 3})));
    }
}
