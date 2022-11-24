package algorithm;

import structure.Node;

/**
 * @author zjn
 **/
public class MaximumDepthOfNaryTree {
    // 递归法
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                depth = Math.max(depth, maxDepth(child));
            }
        }
        return depth + 1;
    }
}
