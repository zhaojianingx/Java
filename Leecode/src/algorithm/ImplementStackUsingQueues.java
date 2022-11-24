package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zjn
 **/
public class ImplementStackUsingQueues {
    Deque<Integer> queue;
    public ImplementStackUsingQueues() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        int size = queue.size();
        size--;
        while (size-- > 0) {
            queue.addLast(queue.peekFirst());
            queue.pollFirst();
        }
        int res = queue.pollFirst();
        return res;
    }

    public int top() {
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues obj = new ImplementStackUsingQueues();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
