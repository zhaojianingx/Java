package algorithm;

/**
 * @author zjn
 **/
public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            if (t == 1) {
                ans |= (1 << (31 - i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(2));
    }
}
