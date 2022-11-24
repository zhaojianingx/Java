package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zjn
 **/
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] tokens = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(tokens[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new UniqueMorseCodeWords().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
