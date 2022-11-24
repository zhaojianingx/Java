package algorithm;

/**
 * @author zjn
 **/
public class RotatingTheBox {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];

        // 对每一行遍历时用一个指针记录下一个石头将要掉落的位置
        for (int i = 0; i < m; i++) {
            int k = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                // 如果遍历位置为记录位置，直接拷贝
                if (j == k) {
                    ans[j][m - 1 - i] = box[i][j];
                    if (box[i][j] != '.') { // 当前位置不为空时指针迭代
                        k--;
                    }
                } else {
                    if (box[i][j] == '#') { // 当前位置为石头则石头掉落
                        ans[k][m - 1 - i] = '#';
                        ans[j][m - 1 - i] = '.';
                        k--;
                    } else if (box[i][j] == '*') { // 为障碍时拷贝并迭代指针
                        ans[j][m - 1 - i] = '*';
                        k = j - 1;
                    } else { // 为空时拷贝
                        ans[j][m - 1 - i] = '.';
                    }
                }
            }
        }
        return ans;
    }
}
