package hashtable;

import java.util.*;

// performance of this beats trie version
public class _1268_search_suggestion_system {
    public List<List<String>> suggestedProducts(String[] repository, String customerQuery) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : repository) {
            for(int len = 1; len <= str.length(); len++) {
                String prefix = str.substring(0, len);
                List<String> list = map.getOrDefault(prefix, new ArrayList<>());
                list.add(str);
                map.put(prefix, list);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(int len = 1; len <= customerQuery.length(); len++) {
            String prefix = customerQuery.substring(0, len);
            List<String> list = map.getOrDefault(prefix, new ArrayList<>());
            // if(!list.isEmpty()) {
            Collections.sort(list, (o1,o2)-> {
                return o1.compareTo(o2);
            });
            if(list.size() > 3) {
                list = list.subList(0, 3);
            }
            // }

            res.add(list);
        }
        return res;
    }
}
