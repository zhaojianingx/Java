package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class BinaryTreeCameras {
    int res = 0;

    public int minCameraCover(TreeNode root) {
        // 对根节点的状态做检验，防止根节点是无覆盖状态
        if (minCame(root) == 0) {
            res++;
        }
        return res;
    }

    /*
        节点的状态值：
            0表示无覆盖
            1表示有摄像头
            2表示有覆盖
        后续遍历，根据左右节点的情况来判断自己的状态
     */
    private int minCame(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);
        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeCameras().minCameraCover(TreeNode.constructBinaryTree(new int[]{0, 0, -1, 0, 0})));
    }
}
