package algorithm;

/**
 * @author zjn
 **/
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("ab", "bac"));
    }
}
