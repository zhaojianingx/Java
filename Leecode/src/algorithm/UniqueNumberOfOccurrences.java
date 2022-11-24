package algorithm;

/**
 * @author zjn
 **/
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2002];
        for (int j : arr) {
            count[j + 1000]++;
        }
        boolean[] flag = new boolean[1002]; // 标记相同频率是否重复出现
        for (int i = 0; i <= 2000; i++) {
            if (count[i] > 0) {
                if (!flag[count[i]]) {
                    flag[count[i]] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }
}
