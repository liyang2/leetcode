package amazon;

import java.util.*;

public class _1010_music_pairs {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int t: time) {

            if(t % 60 == 0) {
                res += map.getOrDefault(0, 0);
            } else {
                int pair = 60 - t % 60;
                res += map.getOrDefault(pair, 0);
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0)+1);
        }
        return res;
    }
}
