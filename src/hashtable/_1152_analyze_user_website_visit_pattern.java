package hashtable;
import java.util.*;
public class _1152_analyze_user_website_visit_pattern {

    /*

    ["h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"]
[527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930]
["hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"]

     */
    public static void main(String[] args) {
        String[] username = {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] time = {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] website = {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};

        new _1152_analyze_user_website_visit_pattern().mostVisitedPattern(username, time, website);
    }
    static class Visit{
        String username;
        String website;
        int timestamp;
        public Visit(String u, String w, int t) {
            username = u;
            website = w;
            timestamp = t;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // sort first based on time
        int n = username.length;
        Visit[] arr = new Visit[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Visit(username[i], website[i], timestamp[i]);
        }
        Arrays.sort(arr, (o1, o2)-> Integer.compare(o1.timestamp, o2.timestamp));

        Map<String, List<String>> userHistory = new HashMap<>();

        for(int i = 0; i < n; i++) {
            userHistory.computeIfAbsent(arr[i].username, e-> new ArrayList<>()).add(arr[i].website);
        }
        Map<List<String>, Integer> count = new HashMap<>();
        for(String user: userHistory.keySet()) {
            List<String> history = userHistory.get(user);
            if(history.size()<3) continue;
            for(List<String> pattern : generate(history)) {
                count.put(pattern, count.getOrDefault(pattern, 0)+1);
            }
        }

        List<String> res = null;

        for(List<String> pattern : count.keySet()) {
            if(res == null || count.get(pattern) > count.get(res) ||
                    (count.get(pattern) == count.get(res) && compare(pattern, res) < 0)) {
                res = pattern;
            }
        }

        return res;
    }


    int compare(List<String> str1, List<String> str2) {
        for(int i = 0; i < 3; i++) {
            int val = str1.get(i).compareTo(str2.get(i));
            if(val != 0)
                return val;
        }
        return 0;
    }

    Set<List<String>> generate(List<String> websitesList) {
        Set<List<String>> setOfListSeq= new HashSet<>();
        for(int i=0;i<websitesList.size();i++){
            for(int j=i+1;j<websitesList.size();j++){
                for(int k=j+1;k<websitesList.size();k++){
                    List<String> list = new ArrayList<>();
                    list.add(websitesList.get(i));
                    list.add(websitesList.get(j));
                    list.add(websitesList.get(k));
                    setOfListSeq.add(list);
                }
            }
        }
        return setOfListSeq;
    }

    // This only works if the list is sorted, however for this question the order can't be changed
//    List<List<String>> generate(List<String> website) {
//        List<List<String>> res = new ArrayList<>();
//        int n = website.size();
//        for(int i = 0; i < n; i++) {
//            while(i > 0 && i < n && website.get(i).equals(website.get(i-1))) i++;
//            for(int j = i+1; j < n; j++) {
//                while(j > i+1 && j < n && website.get(j).equals(website.get(j-1))) j++;
//                for(int k = j+1; k < n; k++) {
//                    while(k > j+1 && k < n && website.get(k).equals(website.get(k-1))) k++;
//                    if(k < n)
//                        res.add(Arrays.asList(website.get(i), website.get(j), website.get(k)));
//                }
//            }
//        }
//        return res;
//    }
}
