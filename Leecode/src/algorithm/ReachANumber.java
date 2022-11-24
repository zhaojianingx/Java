package algorithm;

/**
 * @author zjn
 **/
public class ReachANumber {
    public int reachNumber(int target) {
        if (target < 0) target = -target;
        int k = (int) Math.sqrt(2 * target), dist = k * (k + 1) / 2;
        while (dist < target || (dist - target) % 2 == 1) {
            k++;
            dist = k * (k + 1) / 2;
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(new ReachANumber().reachNumber(2));
    }
}
