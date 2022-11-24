package structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 * @author zjn
 **/
public class TreeNode {
    // 节点值
    public int val;
    // 左节点
    public TreeNode left;
    // 右节点
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 根据数组构建二叉树
     * @param arr 树的数组表示
     * @return 构建成功后树的根节点
     */
    public static TreeNode constructBinaryTree(final int[] arr) {
        List<TreeNode> treeNodeList = arr.length > 0 ? new ArrayList<>(arr.length) : null;
        TreeNode root = null;
        // 把输入数值数组，先转化为二叉树节点列表
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = null;
            if (arr[i] != -1) {
                node = new TreeNode(arr[i]);
            }
            treeNodeList.add(node);
            if (i == 0) {
                root = node;
            }
        }
        // 遍历一遍，根据规则为左右孩子赋值
        // 结束规则是i * 2 + 2 < arr.length
        for (int i = 0; i * 2 + 2 < arr.length; i++) {
            TreeNode node = treeNodeList.get(i);
            if (node != null) {
                // 线性存储转为链式存储
                node.left = treeNodeList.get(2 * i + 1);
                node.right = treeNodeList.get(2 * i + 2);
            }
        }
        return root;
    }

    public static List<Integer> LevelOrderTraversal(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        if (treeNode == null)  return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode tempNode = queue.poll();
                result.add(tempNode.val);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
                len--;
            }
        }
        return result;
    }
}
