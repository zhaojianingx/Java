package algorithm;

/**
 * @author zjn
 **/
public class ectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])) && (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

    public static void main(String[] args) {
        System.out.println(new ectangleOverlap().isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
    }
}
