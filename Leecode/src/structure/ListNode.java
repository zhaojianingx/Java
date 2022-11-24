package structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表
 * @author zjn
 **/
public class ListNode {
    // 节点的值
    public int val;
    // 下一个节点
    public ListNode next;

    // 构造函数
    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 根据数组构建单链表
     * @param arr 单链表的数组表示
     * @return 构建成功后单链表的头节点
     */
    public static ListNode constructSingleList(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(-1, null);
        ListNode cur = head;
        for (int item : arr) {
            ListNode node = null;
            if (item != -1) {
                node = new ListNode(item);
            }
            cur.next = node;
            cur = cur.next;
        }
        return head.next;
    }

    /**
     * 将单链表转化为List
     * @param head
     * @return
     */
    public static List<Integer> toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
