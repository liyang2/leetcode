package arrary;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _697_degree_of_array {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            left.putIfAbsent(nums[i], i);
            right.put(nums[i], i);
            counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);
        }
        int maxFreq = Collections.max(counts.values());
        int res = nums.length;
        for(int n : counts.keySet()) {
            if(counts.get(n) == maxFreq) {
                res = Math.min(res, right.get(n) - left.get(n) + 1);
            }
        }
        return res;
    }
}
