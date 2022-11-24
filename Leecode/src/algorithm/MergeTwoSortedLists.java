package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode result, current;
        // 确定头节点
        if (list1.val < list2.val) {
            result = current = list1;
            list1 = list1.next;
        } else {
            result = current =  list2;
            list2 = list2.next;
        }

        // 进行合并
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        // 只剩一个链表
        if (list1 == null) {
            current.next = list2;
        } else {
            current.next = list1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toArray(new MergeTwoSortedLists().mergeTwoLists(ListNode.constructSingleList(new int[]{1, 2, 4}), ListNode.constructSingleList(new int[]{1, 3, 4}))));
    }
}
