package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class RestoreIPAddresses {
    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        restoreIPAddressesHandler(s, 0, 0);
        return result;
    }

    // number表示stringBuilder中IP段的数量
    private void restoreIPAddressesHandler(String s, int start, int number) {
        // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
        if (start == s.length() && number == 4) {
            result.add(stringBuilder.toString());
            return;
        }
        if (start == s.length() || number == 4) {
            return;
        }
        // 剪枝:ip段的长度最大是3，并且ip段处于[0,255]
        for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
                    && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
            // 如果ip段的长度大于1，并且第一位为0的话，continue
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                continue;
            }
            stringBuilder.append(s.substring(start, i + 1));
            if (number < 3) {
                stringBuilder.append(".");
            }
            number++;
            restoreIPAddressesHandler(s, i + 1, number);
            number--;
            // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
            stringBuilder.delete(start + number, i + number + 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }
}
