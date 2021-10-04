package hashtable;
import java.util.*;
public class _128_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }

        int res = 0;
        for(int n: nums) {
            int curStreak = 1;

            // n is start of sequence
            if(!set.contains(n-1)) {
                while(set.contains(n+1)) {
                    curStreak++;
                    n++;
                }
                res = Math.max(res, curStreak);
            }
        }
        return res;
    }
}
