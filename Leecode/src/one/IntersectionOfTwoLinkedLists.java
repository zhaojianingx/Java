package one;

import structure.ListNode;

/**
 * @author zjn
 **/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        if (lenB > lenA) {
            int temp = lenA;
            lenA = lenB;
            lenB = temp;

            ListNode tem = curA;
            curA = curB;
            curB = tem;
        }
        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
