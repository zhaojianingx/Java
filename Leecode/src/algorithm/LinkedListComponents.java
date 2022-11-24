package algorithm;

import structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjn
 **/
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) head = head.next;
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LinkedListComponents().numComponents(ListNode.constructSingleList(new int[]{0, 1, 2, 3}), new int[]{0, 1, 3}));
    }
}
