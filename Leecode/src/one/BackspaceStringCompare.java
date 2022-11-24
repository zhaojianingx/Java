package one;

/**
 * @author zjn
 **/
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return convert(s).equals(convert(t));
    }

    private String convert(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int size = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] == '#') {
                size++;
            } else if (size == 0) {
                sb.append(cs[i]);
            } else {
                size--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
    }
}
