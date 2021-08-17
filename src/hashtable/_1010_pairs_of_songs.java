package hashtable;

public class _1010_pairs_of_songs {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int res = 0;
        for(int t : time) {
            if(t % 60 == 0) {
                res += remainders[0];
            } else {
                int d = 60 - t % 60;
                res += remainders[d];
            }
            remainders[t%60]++;
        }
        return res;
    }
}
