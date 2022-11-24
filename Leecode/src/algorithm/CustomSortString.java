package algorithm;

/**
 * @author zjn
 **/
public class CustomSortString {
    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnt[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i]-- > 0 ) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("cbafg", "abcd"));
    }
}
