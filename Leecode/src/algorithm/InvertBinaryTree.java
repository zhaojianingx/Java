package algorithm;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author zjn
 **/
public class InvertBinaryTree {
    // DFS 递归
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree1(root.left);
        invertTree1(root.right);
        swapChildren(root);
        return root;
    }

    // DFS 迭代
    public TreeNode invertTree2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            } else {
                stack.pop();
                node = stack.pop();
                swapChildren(node);
            }
        }
        return root;
    }

    // BFS
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swapChildren(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.LevelOrderTraversal(new InvertBinaryTree().invertTree2(TreeNode.constructBinaryTree(new int[]{4, 2, 7, 1, 3, 6, 9}))));
    }
}
