package arrary;

import java.util.TreeMap;

public class _1365_how_many_numbers_smaller {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for(int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0)+1);
        }

        int lessNumbers = 0;
        for(int n : counts.keySet()) {
            int temp = counts.get(n);
            counts.put(n, lessNumbers);
            lessNumbers += temp;
        }

        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = counts.get(nums[i]);
        }
        return res;
    }
}
