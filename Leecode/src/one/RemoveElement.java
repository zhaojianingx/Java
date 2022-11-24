package one;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * @author zjn
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int low = 0, high;
        for (high = 0; high < nums.length; high++) {
            if (nums[high] != val) {
                nums[low] = nums[high];
                low++;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
