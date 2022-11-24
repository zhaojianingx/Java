package algorithm;

/**
 * @author zjn
 **/
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        int m = name.length(), n = typed.length();
        while (i < m && j < n) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) return false;
                while (j < n - 1 && typed.charAt(j) == typed.charAt(j - 1)) j++;
                if (name.charAt(i) == typed.charAt(j)) {
                    i++;
                    j++;
                }
                else return false;
            }
        }
        // 说明name没有匹配完
        if (i < m) return false;
        // 说明type没有匹配完
        while (j < n) {
            if (typed.charAt(j) == typed.charAt(j - 1)) j++;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("alex", "aaleex"));
    }
}
