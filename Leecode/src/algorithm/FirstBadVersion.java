package algorithm;

/**
 * @author zjn
 **/
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int error = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                error = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return error;
    }

    boolean isBadVersion(int version) {
        return (version % 2) == 0;
    }
}
