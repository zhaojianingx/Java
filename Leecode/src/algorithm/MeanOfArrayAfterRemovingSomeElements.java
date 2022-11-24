package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class MeanOfArrayAfterRemovingSomeElements {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, total = 0;
        for (int i = n / 20; i < n - n / 20; i++) {
            total += arr[i];
        }
        return total * 1.0 / (n * 0.9);
    }

    public static void main(String[] args) {
        System.out.println(new MeanOfArrayAfterRemovingSomeElements().trimMean(new int[]{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}));
    }
}
