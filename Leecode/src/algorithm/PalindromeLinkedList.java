package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prevSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode nextSlow = slow.next;
            slow.next = prevSlow;
            prevSlow = slow;
            slow = nextSlow;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (prevSlow != null && slow != null) {
            if (prevSlow.val != slow.val) {
                return false;
            }
            prevSlow = prevSlow.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeLinkedList().isPalindrome(ListNode.constructSingleList(new int[]{1, 2, 3, 2, 1})));
    }
}
