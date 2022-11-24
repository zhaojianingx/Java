package algorithm;

import structure.TreeNode;

/**
 * @author zjn
 **/
public class KthSmallestElementInABST {
    int k, ans;
    public int kthSmallest(TreeNode root, int _k) {
        k = _k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null || k <= 0) return;
        dfs(root.left);
        if (--k == 0) ans = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestElementInABST().kthSmallest(TreeNode.constructBinaryTree(new int[]{3, 1, 4, -1, 2}), 1));
    }
}
