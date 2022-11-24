package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            for (String x : genNums(s.substring(0, i))) {
                for (String y : genNums(s.substring(i))) {
                    result.add(new StringBuilder("(").append(x).append(", ").append(y).append(")").toString());
                }
            }
        }
        return result;
    }

    // 将num用小数点分割
    private List<String> genNums(String num) {
        List<String> list = new ArrayList<>();
        int i = 1;
        String left, right;
        while (i <= num.length()) {
            left = num.substring(0, i); // 分割整数部分
            right = num.substring(i++); // 分割小数部分
            if ((!left.equals("0") && left.charAt(0) == '0') ||
                    (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) continue;
            if (right.isEmpty()) list.add(left);
            else list.add(new StringBuilder(left).append(".").append(right).toString());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new AmbiguousCoordinates().ambiguousCoordinates("(123)"));
    }
}
