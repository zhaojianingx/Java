package algorithm;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjn
 **/
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return resList;
        }

        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;
            while (levelSize > 0) {
                TreeNode tempNode = queue.pollFirst();
                max = Math.max(max, tempNode.val);
                if (tempNode.left != null) {
                    queue.offerLast(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offerLast(tempNode.right);
                }
                levelSize--;
            }
            resList.add(max);
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(new FindLargestValueInEachTreeRow().largestValues(TreeNode.constructBinaryTree(new int[]{1, 3, 2, 5, 3, -1, 9})));
    }
}
