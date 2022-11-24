package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjn
 **/
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            int n = s.length(), index = 0;
            while (index < n && s.charAt(index) != ' ') index++;
            int count = Integer.parseInt(s.substring(0, index));
            int start = index + 1;
            index = n - 1;
            while (index >= start) {
                while (index >= start && s.charAt(index) != '.') {
                    index--;
                }
                String cur = s.substring(index + 1);
                map.put(cur, map.getOrDefault(cur, 0) + count);
                index--;
            }
        }
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key) + " " + key);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SubdomainVisitCount().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
