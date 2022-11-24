package algorithm;

/**
 * @author zjn
 **/
public class DominoAndTrominoTiling {
    private static final long MOD = (long) 1e9 + 7;

    public int numTilings(int n) {
        if (n == 1) return 1;
        long a = 1, b = 1, c= 2;
        for (int i = 3; i <= n; i++) {
            long f = (c * 2 + a) % MOD;
            a = b;
            b = c;
            c = f;
        }
        return (int) c;
    }

    public static void main(String[] args) {
        System.out.println(new DominoAndTrominoTiling().numTilings(3));
    }
}
