package greedy;

// greedy in a way that i keeps updating first/second variable with smaller values
// to allow a better chance to third one to show up
public class _334_increasing_triplet_subsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n <= first) {
                first = n;
            } else if(n <= second) {
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
