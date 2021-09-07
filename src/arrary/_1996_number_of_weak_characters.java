package arrary;

import java.util.Arrays;

public class _1996_number_of_weak_characters {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o2[1] - o1[1]; // bigger ones on the left, avoid false positive
            }
            return o1[0] - o2[0];
        });
        int res = 0;

        int maxDefense = 0;
        for(int i = properties.length-1; i >= 0; i--) {
            if(properties[i][1] < maxDefense) {
                res++;
            }
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return res;
    }
}
