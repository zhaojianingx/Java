package algorithm;

import structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zjn
 **/
public class SameTree {
    // 递归法
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
    // 迭代法
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(p);
        deque.offerLast(q);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            deque.offerFirst(left.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.left);
            deque.offerLast(right.right);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SameTree().isSameTree2(TreeNode.constructBinaryTree(new int[]{1, 2, 3}), TreeNode.constructBinaryTree(new int[]{1, 2, 3})));
    }
}
