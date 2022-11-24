package algorithm;

import java.util.List;
import java.util.Objects;

/**
 * @author zjn
 **/
public class CountItemsMatchingARule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int index = ruleKey.equals("color") ? 1 : ruleKey.equals("type") ? 0 : 2;
        for (List<String> item : items) {
            if (Objects.equals(item.get(index), ruleValue)) res++;
        }
        return res;
    }
}
