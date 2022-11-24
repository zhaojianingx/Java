package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = head;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new RemoveDuplicatesFromSortedListII().deleteDuplicates(ListNode.constructSingleList(new int[]{1, 2, 3, 3, 4, 4, 5}))));
    }
}
