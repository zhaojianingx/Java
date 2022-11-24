package algorithm;

/**
 * @author zjn
 **/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (n == 0 || len == 1) {
            return len;
        }
        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                count = 1;
            } else if (cnt[i] == max) {
                count++;
            }
        }
        return Math.max(len, (max - 1) * (n + 1) + count);
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
