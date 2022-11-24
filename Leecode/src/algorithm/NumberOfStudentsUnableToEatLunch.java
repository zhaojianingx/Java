package algorithm;

/**
 * @author zjn
 **/
public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnts = new int[2];
        for (int student : students) cnts[student]++;
        for (int i = 0; i < sandwiches.length; i++) {
            if (--cnts[sandwiches[i]] == -1) return sandwiches.length - i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfStudentsUnableToEatLunch().countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }
}
