package arrary;

import java.util.*;

public class _1560_most_vistited_sector_in_circular_track {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int start = rounds[0];
        int end = rounds[rounds.length-1];



        for(int i = start; i != end; i = i%n+1) {
            res.add(i);
        }
        res.add(end);
        Collections.sort(res);

        return res;
    }
}
