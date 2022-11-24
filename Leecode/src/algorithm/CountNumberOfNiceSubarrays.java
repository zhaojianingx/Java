package algorithm;

/**
 * @author zjn
 **/
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] map = new int[len + 1];
        map[0] = 1;
        int oddnum = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            oddnum += nums[i] & 1;
            if (oddnum - k >= 0) {
                count += map[oddnum - k];
            }
            map[oddnum]++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumberOfNiceSubarrays().numberOfSubarrays(new int[]{1}, 3));
    }
}
