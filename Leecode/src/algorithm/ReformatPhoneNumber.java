package algorithm;

/**
 * @author zjn
 **/
public class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        String s = number.replace(" ", "").replace("-", "");
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            if (sb.length() != 0) sb.append("-");
            if (i + 4 >= n) {
                if (i + 3 >= n) {
                    sb.append(s.substring(i));
                } else {
                    sb.append(s, i, i + 2).append("-").append(s.substring(i + 2));
                }
                break;
            }
            sb.append(s, i, i + 3);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReformatPhoneNumber().reformatNumber("123-34543"));
    }
}
