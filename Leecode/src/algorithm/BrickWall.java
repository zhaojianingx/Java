package algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjn
 **/
public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 2, 1);
        List<Integer> list2 = List.of(3, 1, 2);
        List<Integer> list3 = List.of(1, 3, 2);
        List<Integer> list4 = List.of(2, 4);
        List<Integer> list5 = List.of(3, 1, 2);
        List<Integer> list6 = List.of(1, 3, 1, 1);
        System.out.println(new BrickWall().leastBricks(List.of(list1, list2, list3, list4, list5, list6)));
    }
}
