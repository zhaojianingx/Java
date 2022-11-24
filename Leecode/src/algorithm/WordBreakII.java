package algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zjn
 **/
public class WordBreakII {
    List<String> ans = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        backTracking(s, 0, wordDict);
        return ans;
    }

    private void backTracking(String s, int index, List<String> wordDict) {
        int n = s.length();
        if (index >= n) {
            List<String> tmp = new ArrayList<>(deque);
            StringBuilder tp = new StringBuilder(tmp.get(0));
            for (int i = 1; i < tmp.size(); i++) {
                tp.append(" ").append(tmp.get(i));
            }
            ans.add(tp.toString());
            return;
        }
        for (int i = index; i < n; i++) {
            if (wordDict.contains(s.substring(index, i + 1))) {
                deque.offer(s.substring(index, i + 1));
            } else {
                continue;
            }
            backTracking(s, i + 1, wordDict);
            deque.removeLast();
        }
    }
}
