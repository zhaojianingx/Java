package algorithm;

/**
 * @author zjn
 **/
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ch = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ch;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ch = sum / 2;
        }
        ans.append(ch == 1 ? ch : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "10"));
    }
}
