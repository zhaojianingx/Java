package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int m = target.length;
        for (int i = 1, j = 0; i <= n && j < m; i++) {
            ans.add("Push");
            if (target[j] != i) ans.add("Pop");
            else j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BuildAnArrayWithStackOperations().buildArray(new int[]{1, 3}, 3));
    }
}
