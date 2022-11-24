package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zjn
 **/
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int index = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            index = Math.max(index, edge[chars[i] - 'a']);
            if (i == index) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
