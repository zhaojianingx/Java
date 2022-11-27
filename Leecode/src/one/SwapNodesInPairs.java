package one;

import structure.ListNode;

/**
 * @author zjn
 **/
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new SwapNodesInPairs().swapPairs(ListNode.constructSingleList(new int[]{1, 2, 3, 4}))));
    }
}
