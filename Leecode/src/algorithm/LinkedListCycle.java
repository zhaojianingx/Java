package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 空链表、单节点链表一定不会有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LinkedListCycle().hasCycle(ListNode.constructSingleList(new int[]{3, 2, 0, -4})));
    }
}
