package one;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            // 从(top, left) -> (top, right)
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 从(top + 1, right) -> (bottom, right)
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (top < bottom && left < right) {
                // from (bottom, right - 1) to (bottom, left + 1)
                for (int i = right - 1; i > left; i--)
                    res.add(matrix[bottom][i]);
                // from (bottom, left) to (top - 1, left)
                for (int i = bottom; i > top; i--)
                    res.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
