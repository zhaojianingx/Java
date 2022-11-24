package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int cnt = 0, n = arr.length;
        for (int num : arr) {
            cnt += num;
        }
        if (cnt % 3 != 0) {
            return new int[]{-1, -1};
        } else if (cnt == 0) {
            return new int[]{0, n - 1};
        }
        cnt /= 3;
        int i = find(1, arr), j = find(cnt + 1, arr), k = find(cnt * 2 + 1, arr);
        while (k < n && arr[i] == arr[j] && arr[j] == arr[k]) {
            i++; j++; k++;
        }
        return k == n ? new int[]{i - 1, j} : new int[]{-1, -1};
    }

    private int find(int x, int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            if (s == x) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ThreeEqualParts().threeEqualParts(new int[]{1, 0, 1, 0, 1})));
    }
}
