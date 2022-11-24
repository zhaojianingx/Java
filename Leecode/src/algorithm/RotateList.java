package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }

        cur.next = head;
        k = k % len;
        k = len - k;
        while (k-- > 0) cur = cur.next;

        head = cur.next;
        cur.next = null;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new RotateList().rotateRight(ListNode.constructSingleList(new int[]{1, 2, 3, 4, 5}), 2)));
    }
}
