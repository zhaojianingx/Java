package algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zjn
 **/
public class MinStack {

    Deque<Long> stack;
    private long min;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.addFirst(0L);
            return;
        }
        stack.push((long)val - min);
        min = Math.min((long)val, min);
    }

    public void pop() {
        long pop = stack.removeFirst();
        if (pop < 0) {
            long lastMin = min;
            min = lastMin - pop;
        }
    }

    public int top() {
        long peek = stack.peekFirst();
        if (peek <= 0) return (int)min;
        return (int)(min + peek);
    }

    public int getMin() {
        return (int)min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(-1);
        System.out.println(obj.top());
    }
}
