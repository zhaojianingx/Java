package algorithm;

/**
 * @author zjn
 **/
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] f = new double[query_row + 10][query_row + 10];
        f[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] <= 1) continue;
                f[i + 1][j] += (f[i][j] - 1) / 2;
                f[i + 1][j + 1] += (f[i][j] - 1) / 2;
            }
        }
        return Math.min(f[query_row][query_glass], 1);
    }

    public static void main(String[] args) {
        System.out.println(new ChampagneTower().champagneTower(2, 1, 1));
    }
}
