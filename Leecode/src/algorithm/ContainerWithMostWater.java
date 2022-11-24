package algorithm;

/**
 * @author zjn
 **/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, result = 0;
        while (l < r) {
            while (l < r && height[l] <= height[r]) {
                result = Math.max(result, height[l] * (r - l++));
            }
            while (l < r && height[l] >= height[r]) {
                result = Math.max(result, height[r] * (r-- - l));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
