package algorithm;

/**
 * @author zjn
 **/
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int[] map = new int[k];
        map[0] = 1;
        int len = nums.length;
        int presum = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            presum += nums[i];
            int key = (presum % k + k) % k;
            count += map[key]++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
