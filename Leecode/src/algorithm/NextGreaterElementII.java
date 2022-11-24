package algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zjn
 **/
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        // 边界判断
        if (nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int size = nums.length;
        int[] result = new int[size]; // 存放结果
        Arrays.fill(result, -1); // 默认全部初始化为-1
        Stack<Integer> stack = new Stack<>(); // 栈中存放的是nums中的元素下标
        for (int i = 0; i < 2 * size; i++) {
            while (!stack.isEmpty() && nums[i % size] > nums[stack.peek()]) {
                result[stack.peek()] = nums[i % size];
                stack.pop();
            }
            stack.push(i % size);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(new int[]{1, 2, 1})));
    }
}
