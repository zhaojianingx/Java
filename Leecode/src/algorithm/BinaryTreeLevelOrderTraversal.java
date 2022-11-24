package algorithm;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zjn
 **/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //checkFun01(root, 0);
        checkFun02(root);
        return resList;
    }

    // DFS--递归方式
    private void checkFun01(TreeNode node, int deep) {
        if (node == null) return;
        deep++;
        if (resList.size() < deep) {
            // 当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            resList.add(item);
        }
        resList.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

    // BFS--迭代方式--借助队列
    private void checkFun02(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode tempNode = queue.poll();
                itemList.add(tempNode.val);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                len--;
            }
            resList.add(itemList);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(TreeNode.constructBinaryTree(new int[]{3, 9, 20, -1, -1, 15, 7})));
    }
}
