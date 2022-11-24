package algorithm;

import structure.Node;

import java.util.*;

/**
 * @author zjn
 **/
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node poll = queue.pollFirst();
                levelList.add(poll.val);
                List<Node> children = poll.children;
                if (children == null || children.size() == 0) {
                    continue;
                }
                for (Node child : children) {
                    if (child != null) {
                        queue.offerLast(child);
                    }
                }
            }
            result.add(levelList);
        }
        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(node, new Node(2), new Node(4)));
        System.out.println(new NaryTreeLevelOrderTraversal().levelOrder(root));
    }
}
