package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zjn
 **/
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 循环遍历
        for (int num : nums) {
            // 已经存在，则去除
            if (set.contains(num)) {
                set.remove(num);
            } else { // 否则存入set
                set.add(num);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for (int item : set) {
            res[i] = item;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
