package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zjn
 **/
public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            } else {
                int t = 0, f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else {
                        f++;
                    }
                }
                stack.pop();
                char op = stack.pop();
                switch (op) {
                    case '!' -> stack.push(f == 1 ? 't' : 'f');
                    case '&' -> stack.push(f == 0 ? 't' : 'f');
                    case '|' -> stack.push(t > 0 ? 't' : 'f');
                }
            }
        }
        return stack.pop() == 't';
    }

    public static void main(String[] args) {
        System.out.println(new ParsingABooleanExpression().parseBoolExpr("|(f,f,f,t)"));
    }
}
