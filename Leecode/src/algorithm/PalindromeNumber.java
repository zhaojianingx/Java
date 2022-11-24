package algorithm;

/**
 * @author zjn
 **/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int cur = 0;
        int num = x;
        while (num != 0) {
            if (cur > Integer.MAX_VALUE / 10) return false;
            cur = cur * 10 + num % 10;
            num = num / 10;
        }
        return cur == x;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(Integer.MAX_VALUE));
    }
}
