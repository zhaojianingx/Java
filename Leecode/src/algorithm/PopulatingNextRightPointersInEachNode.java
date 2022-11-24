package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zjn
 **/
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        Queue<Node> temQueue = new LinkedList<>();
        if (root != null) temQueue.add(root);
        while (!temQueue.isEmpty()) {
            int size = temQueue.size();
            Node cur = temQueue.poll();
            if (cur.left != null) temQueue.add(cur.left);
            if (cur.right != null) temQueue.add(cur.right);

            for (int index = 1; index < size; index++) {
                Node next = temQueue.poll();
                if (next.left != null) temQueue.add(next.left);
                if (next.right != null) temQueue.add(next.right);

                cur.next = next;
                cur = next;
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};