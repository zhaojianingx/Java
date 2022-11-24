package algorithm;

/**
 * @author zjn
 **/
public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') count++;
            else count--;
            if (count == 0) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SplitAStringInBalancedStrings().balancedStringSplit("RLRRLLRLRL"));
    }
}
