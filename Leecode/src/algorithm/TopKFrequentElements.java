package algorithm;

import java.util.*;

/**
 * @author zjn
 **/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set< Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值，构建一个大顶堆（o1 - o2小顶堆  o2 - o1大顶堆）
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
        }
        for (int i = k -1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5, 5 ,1, 2, 1}, 2)));
    }
}
