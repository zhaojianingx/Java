package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(candies[i] + extraCandies >= maxCandies);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new KidsWithTheGreatestNumberOfCandies().kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }
}
