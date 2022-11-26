package one;

import structure.ListNode;

/**
 * @author zjn
 **/
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new RemoveLinkedListElements().removeElements(ListNode.constructSingleList(new int[]{6, 6, 6}), 6)));
    }
}
