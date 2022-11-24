package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return merge2Lists(l1, l2);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new MergeKSortedLists().mergeKLists(new ListNode[]{ListNode.constructSingleList(new int[]{1, 4, 5}),
                ListNode.constructSingleList(new int[]{1, 3, 4}), ListNode.constructSingleList(new int[]{2, 6})})));
    }
}
