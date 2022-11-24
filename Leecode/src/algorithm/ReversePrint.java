package algorithm;

import structure.ListNode;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class ReversePrint {
    int[] res;
    int i = 0;
    int j = 0;
    public int[] reversePrint(ListNode head) {
        reverse(head);
        return res;
    }

    private void reverse(ListNode head) {
        if (head == null) {
            res = new int[i];
            return;
        }
        i++;
        reverse(head.next);
        res[j++] = head.val;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReversePrint().reversePrint(ListNode.constructSingleList(new int[]{1, 2, 3}))));
    }
}
