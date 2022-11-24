package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
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
        System.out.println(ListNode.toArray(new RemoveLinkedListElements().removeElements(ListNode.constructSingleList(new int[]{1, 2, 6, 3, 4, 5, 6}), 6)));
    }
}
