package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头节点和相遇节点，各走一步，知道相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        System.out.println((new LinkedListCycleII().detectCycle(listNode1)).val);
    }
}
