package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class ReverseLinkedList {
    // 双指针
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
        // 递归
    }

    // 从后向前递归
    public ListNode reverseList1(ListNode head) {
        // 边缘条件判断
        if (head == null) return null;
        if (head.next == null) return head;

        // 递归调用，反转第二届节点开始往后的链表
        ListNode last = reverseList1(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的head节点为尾节点，next需要指向NULL
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new ReverseLinkedList().reverseList1(ListNode.constructSingleList(new int[]{1, 2, 3, 4, 5}))));
    }
}
