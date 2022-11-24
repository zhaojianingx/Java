package algorithm;

/**
 * @author zjn
 **/
public class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        int len = word.length(), sLen = sequence.length();
        if (len > sLen) return 0;
        if (sequence.equals(word)) return 1;
        int res = 0;
        int left = 0;
        int maxCount = 0;
        boolean flag = false;
        while (left <= sLen - len) {
            if (sequence.substring(left, left + len).equals(word)) {
                res++;
                left += len;
                flag = true;
            } else {
                if (flag) {
                    left = left - len + 1;
                    flag = false;
                } else {
                    left++;
                }
                maxCount = Math.max(maxCount, res);
                res = 0;
            }
        }
        maxCount = Math.max(maxCount, res);
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumRepeatingSubstring().maxRepeating("ababc", "ab"));
    }
}
