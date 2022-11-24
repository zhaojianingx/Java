package algorithm;

import structure.ListNode;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class ConvertSortedListToBinarySearchTree {
    List<Integer> res = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            res.add(temp.val);
            temp = temp.next;
        }
        return construct(res, 0, res.size() - 1);
    }

    private TreeNode construct(List<Integer> res, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(res.get(mid));
        root.left = construct(res, left, mid - 1);
        root.right = construct(res, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(TreeNode.LevelOrderTraversal(new ConvertSortedListToBinarySearchTree().sortedListToBST(ListNode.constructSingleList(new int[]{-10, -3, 0, 5, 9}))));
    }
}
