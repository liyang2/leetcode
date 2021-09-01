package arrary;

public class _370_range_addition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];

            res[start] += val;
            if(end+1 < res.length)
                res[end+1] -= val;
        }

        int d = 0;
        for(int i = 0; i < res.length; i++) {
            d += res[i];
            res[i] = d;
        }
        return res;
    }
}
