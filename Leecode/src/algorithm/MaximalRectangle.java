package algorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zjn
 **/
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[] heights = new int[col + 1];
        heights[col] = -1;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + matrix[i][j] - '0' : 0;
            }
            res = Math.max(res, largestRectangleArea(Arrays.copyOf(heights, col + 1)));
        }
        return res;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int len = heights.length;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                int top = -1;
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    top = stack.pop();
                    maxArea = Math.max(maxArea, heights[top] * (i - top));
                }
                heights[top] = heights[i];
                stack.push(top);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}}));
    }
}
