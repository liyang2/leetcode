package slidingWindow;
import java.util.*;

// 此题算two pointer/sliding window的顶峰了吧
// this one is special in two ways:
// 1: it's looking for windows with exactly k elements
// 2: it's looking for number of such windows, not the min/max length of the window
public class _992_subarrays_with_k_different_integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k) - atMostK(nums,k-1);
    }

    private int atMostK(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        for (; r < nums.length; r++) {
            countMap.put(nums[r], countMap.getOrDefault(nums[r], 0) + 1);
            while (countMap.size() > k) {
                countMap.put(nums[l], countMap.get(nums[l]) - 1);
                if (countMap.get(nums[l]) == 0) {
                    countMap.remove(nums[l]);
                }
                l++;
            }
            res += r - (l - 1); // window size
        }
        return res;
    }
}
