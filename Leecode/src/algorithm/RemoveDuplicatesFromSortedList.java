package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new RemoveDuplicatesFromSortedList().deleteDuplicates(ListNode.constructSingleList(new int[]{1, 1, 2}))));
    }
}
