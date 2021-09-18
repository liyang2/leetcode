package arrary;

import java.util.*;

public class _448_find_all_numbers_disappeared_in_array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num-1] > 0) {
                nums[num-1] *= -1;
            }
        }
        List<Integer> res= new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
