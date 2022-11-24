package algorithm;

import structure.ListNode;

/**
 * @author zjn
 **/
public class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = ans * 2 + head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ConvertBinaryNumberInALinkedListToInteger().getDecimalValue(ListNode.constructSingleList(new int[]{1, 0, 1})));
    }
}
