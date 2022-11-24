package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zjn
 **/
public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (char c : s.toCharArray()) {
            if (c == '(') deque.addLast(0);
            else {
                int cur = deque.pollLast();
                deque.addLast(deque.pollLast() + Math.max(cur * 2, 1));
            }
        }
        return deque.peekLast();
    }

    public static void main(String[] args) {
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("((()))()"));
    }
}
