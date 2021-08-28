package priorityQueue;

import java.util.*;

public class _692_top_k_frequent_words {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((o1, o2) -> {
            if(o1.getValue() == o2.getValue()) {
                return o2.getKey().compareTo(o1.getKey());
            } else {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            q.add(entry);
            if(q.size() > k) q.poll();
        }
        List<String> resStr = new ArrayList<>();
        while(!q.isEmpty()) {
            resStr.add(q.poll().getKey());
        }
        Collections.reverse(resStr);
        return resStr;
    }

    public static void main(String[] args) {
//        new _692_top_k_frequent_words().topKFrequent(new String[]{"i","love", "leetcode","i","love","coding"}, 2);

    }
}
