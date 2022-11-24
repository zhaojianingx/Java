package algorithm;

/**
 * @author zjn
 **/
public class FindFirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int l = 0, r = word.length() - 1;
        while (l < r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new FindFirstPalindromicStringInTheArray().firstPalindrome(new String[]{"abc", "ada", "bac"}));
    }
}
