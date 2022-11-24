package algorithm;

/**
 * @author zjn
 **/
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            int end = Math.min(ch.length - 1, start + k -1);
            while (start < end) {
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("abcdefg",2));
    }
}
