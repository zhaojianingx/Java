package algorithm;

/**
 * @author zjn
 **/
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        // 将res当作栈
        StringBuilder res = new StringBuilder();
        // top作为res的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当top>0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时top--
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
            } else {
                // 否则将该字符入栈，同时top++
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates("aacddca"));
    }
}
