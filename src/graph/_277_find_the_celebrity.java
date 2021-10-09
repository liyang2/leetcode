package graph;

import java.util.*;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
class Relation {
    boolean knows(int a, int b) {
        return true;
    }
}
class Solution extends Relation {
    Map<List<Integer>, Boolean> map = new HashMap<>();

    @Override
    boolean knows(int a, int b) {
        List<Integer> key = Arrays.asList(a, b);
        if(map.containsKey(key)) {
            return map.get(key);
        } else {
            boolean res = super.knows(a,b);
            map.put(key, res);
            return res;
        }
    }

    public int findCelebrity(int n) {
        int c = 0; // candidate
        for(int i = 1; i < n; i++) {
            if(knows(c, i)) {
                c = i;
            }
        }
        for(int i = 0; i < n; i++) {
            if(i == c) continue;
            if(knows(c, i) || !knows(i, c))
                return -1;
        }
        return c;
    }
}