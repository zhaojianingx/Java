package algorithm;

/**
 * @author zjn
 **/
public class AverageSalaryExcludingtheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int n = salary.length, mins = Integer.MAX_VALUE, maxs = 0, count = 0;
        for (int number : salary) {
            count += number;
            maxs = Math.max(maxs, number);
            mins = Math.min(mins, number);
        }
        return (double) (count - mins - maxs) / (n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new AverageSalaryExcludingtheMinimumAndMaximumSalary().average(new int[]{1000, 2000, 2000, 3000}));
    }
}
