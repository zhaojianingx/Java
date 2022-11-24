package algorithm;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class SumRootToLeafNumbers {
    List<Integer> path = new ArrayList<>();
    int res = 0;

    public int sumNumbers(TreeNode root) {
        // 如果节点为0，则返回0
        if (root == null) return 0;
        // 首先将根节点放到集合中
        path.add(root.val);
        recur(root);
        return res;
    }

    private void recur(TreeNode root) {
        if (root.left == null && root.right == null) {
            // 当是叶子节点的时候，开始处理
            res += listToInt(path);
            return;
        }
        if (root.left != null) {
            // 回溯
            path.add(root.left.val);
            recur(root.left);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            // 回溯
            path.add(root.right.val);
            recur(root.right);
            path.remove(path.size() - 1);
        }
        return;
    }

    private int listToInt(List<Integer> path) {
        int sum = 0;
        for (Integer num : path) {
            sum = sum * 10 + num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumRootToLeafNumbers().sumNumbers(TreeNode.constructBinaryTree(new int[]{4, 9, 0, 5, 1})));
    }
}
