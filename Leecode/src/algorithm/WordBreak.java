package algorithm;

import java.util.List;

/**
 * @author zjn
 **/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // valid[i]：字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && valid[j]) {
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", List.of("leet", "code")));
    }
}
