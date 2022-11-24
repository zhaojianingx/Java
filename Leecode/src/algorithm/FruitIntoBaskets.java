package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjn
 **/
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;
        int n = fruits.length;

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0,left = 0;
        for (int i = 0; i < n; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new FruitIntoBaskets().totalFruit(new int[]{0, 0, 1, 1, 2, 1}));
    }
}
