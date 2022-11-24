package algorithm;

/**
 * @author zjn
 **/
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                res.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                res.append(' ');
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII().reverseWords("Hello World"));
    }
}
