package one;

import structure.ListNode;

/**
 * @author zjn
 **/
public class ReverseLinkedList {
    // 双指针法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next; //保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // 递归法
    public ListNode reverseList1(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next; // 先保存下一个节点
        cur.next = prev; //反转
        return reverse(cur, temp);
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new ReverseLinkedList().reverseList(ListNode.constructSingleList(new int[] {1, 2, 3, 4, 5}))));
    }
}
