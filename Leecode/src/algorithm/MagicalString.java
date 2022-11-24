package algorithm;

/**
 * @author zjn
 **/
public class MagicalString {
    public int magicalString(int n) {
        int[] magic = new int[n + 1];
        magic[0] = 1;
        int tail = 1, count = 2, value = 1, result = 1, p = 1;
        while (tail < n) {
            value = value ^ 3;
            while (count-- > 0 && tail < n) {
                magic[tail++] = value;
                if (value == 1) result++;
            }
            count = magic[++p];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MagicalString().magicalString(6));
    }
}
