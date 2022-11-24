package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjn
 **/
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean flag = set.add(num);
            if (!flag) return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindRepeatNumber().findRepeatNumber(new int[]{8, 3, 2, 0, 2}));
    }
}
