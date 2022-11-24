package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode l = left;
        ListNode r = right;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                left.next = temp;
                left = left.next;
            } else {
                right.next = temp;
                right = right.next;
            }
            temp = temp.next;
        }
        right.next = null;
        left.next = r.next;
        return l.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new PartitionList().partition(ListNode.constructSingleList(new int[]{1, 4, 3, 2, 5, 2}), 3)));
    }
}
