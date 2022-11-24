package algorithm;

import java.util.*;

/**
 * @author zjn
 **/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String ,List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] target = str.toCharArray();
            Arrays.sort(target);
            String key = new String(target);

            List<String> list = new ArrayList<>();
            list.add(str);

            if (map.containsKey(key)) {
                list.addAll(map.get(key));
            }
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
