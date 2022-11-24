package algorithm;

/**
 * @author zjn
 **/
public class CellsWithOddValuesInAMatrix {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] r = new boolean[m], c = new boolean[n];
        int a = 0, b = 0;
        for (int[] info : indices) {
            a += (r[info[0]] = !r[info[0]]) ? 1 : -1;
            b += (c[info[1]] = !c[info[1]]) ? 1 : -1;
        }
        return a * (n - b) + (m - a) * b;
    }

    public static void main(String[] args) {
        System.out.println(new CellsWithOddValuesInAMatrix().oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}
