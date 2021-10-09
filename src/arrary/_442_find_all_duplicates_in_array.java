package arrary;
import java.util.*;
public class _442_find_all_duplicates_in_array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int n : nums) {
            int idx = Math.abs(n)-1;
            if(nums[idx] < 0)
                res.add(Math.abs(n));
            nums[idx] *= -1;
        }

        return res;
    }
}
