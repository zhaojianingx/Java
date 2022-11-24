package algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zjn
 **/
public class OnlineStockSpan {
    Deque<int[]> stack = new LinkedList<>();

    public void StockSpanner() {

    }

    public int next(int price) {
        int[] res = new int[]{price, 1};
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            res[1] += stack.pop()[1];
        }
        stack.push(res);
        return res[1];
    }
}
