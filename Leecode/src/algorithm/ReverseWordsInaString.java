package algorithm;

/**
 * @author zjn
 **/
public class ReverseWordsInaString {
    public String reverseWords(String s) {
        // 步骤一：字符串整体反转
        char[] initialArr = s.toCharArray();
        reverse(initialArr, 0, s.length() - 1);
        int k = 0;
        for (int i = 0; i < initialArr.length; i++) {
            if (initialArr[i] == ' ') {
                continue;
            }
            int tempCur = i;
            while (i < initialArr.length && initialArr[i] != ' ') {
                i++;
            }
            for (int j = tempCur; j < i; j++) {
                // 步骤二：二次反转
                if (j == tempCur) {
                    reverse(initialArr, tempCur, i - 1);
                }
                // 步骤三：移动操作
                initialArr[k++] = initialArr[j];
                // 遍历结束
                if (j == i - 1) {
                    // 避免越界情况
                    if (k < initialArr.length) {
                        initialArr[k++] = ' ';
                    }
                }
            }
        }
        if (k == 0) {
            return "";
        } else {
            return new String(initialArr, 0, (k == initialArr.length) && (initialArr[k - 1] != ' ') ? k : k - 1);
        }
    }

    private void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInaString().reverseWords("  hello world  "));
    }
}
