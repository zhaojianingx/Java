package algorithm;

import structure.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zjn
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head.next;
        while (cur != null) {
            deque.offer(cur);
            cur = cur.next;
        }
        cur = head;

        int count = 0;
        while (!deque.isEmpty()) {
            if (count % 2 == 0) {
                cur.next = deque.pollLast();
            } else {
                cur.next = deque.poll();
            }
            cur = cur.next;
            count++;
        }
        cur.next = null;
    }

    public static void main(String[] args) {
        new ReorderList().reorderList(ListNode.constructSingleList(new int[]{1, 2, 3, 4, 5}));
    }
}
