package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjn
 **/
public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node node = null;
            Node preNode = null;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    preNode = queue.poll();
                    node = preNode;
                } else {
                    node = queue.poll();
                    preNode.next = node;
                    preNode = preNode.next;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            preNode.next = null;
        }
        return root;
    }
}
