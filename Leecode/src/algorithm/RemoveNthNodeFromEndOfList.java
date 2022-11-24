package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (n-- > 0) {
            fast = fast.next;
        }
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        slow.next = null;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new RemoveNthNodeFromEndOfList().removeNthFromEnd(ListNode.constructSingleList(new int[]{1, 2}), 1)));
    }
}
