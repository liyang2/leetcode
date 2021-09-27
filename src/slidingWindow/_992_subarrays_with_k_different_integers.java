package slidingWindow;
import java.util.*;

// this one is special in two ways:
// 1: it's looking for windows with exactly k elements
// 2: it's looking for number of such windows, not the min/max length of the window
public class _992_subarrays_with_k_different_integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }

    int atMostK(int[] nums, int k) {
        int l = 0, r = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int counter = 0;
        for(r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            if(map.get(nums[r]) == 1) {
                counter++;
            }
            while(l <= r && counter > k) {
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l]) == 0) {
                    counter--;
                }
                l++;
            }
            res += (r - l + 1);
        }
        return res;
    }
}
