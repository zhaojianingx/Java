package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new SwapNodesInPairs().swapPairs(ListNode.constructSingleList(new int[]{}))));
    }
}
