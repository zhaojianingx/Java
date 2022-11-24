package algorithm;

/**
 * @author zjn
 **/
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[][] matrix = new int[n + 1][n + 1];
        for (int[] item : dislikes) {
            matrix[item[0]][item[1]] = matrix[item[1]][item[0]] = 1;
        }
        int[] record = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (record[i] == 0 && !dfs(matrix, record, i, 1, n)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] matrix, int[] record, int index, int group, int n) {
        record[index] = group;
        for (int i = 1; i <= n; i++) {
            if (i == index) continue;;
            if (matrix[index][i] == 1 && record[i] == group) return false;
            if (matrix[index][i] == 1 && record[i] == 0 && !dfs(matrix, record, i, -1 * group, n)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PossibleBipartition().possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
    }
}
