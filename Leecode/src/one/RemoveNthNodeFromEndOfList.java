package one;

import algorithm.ExpressiveWords;
import structure.ListNode;

/**
 * @author zjn
 **/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNode.constructSingleList(new int[]{1, 2}), 1)));
    }
}
