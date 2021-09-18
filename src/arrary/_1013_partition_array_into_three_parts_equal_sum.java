package arrary;

import java.util.Arrays;

public class _1013_partition_array_into_three_parts_equal_sum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if(sum % 3 != 0)
            return false;
        sum /= 3;
        int cur = 0;
        int segs = 0;
        for(int n : arr) {
            cur +=n;
            if(cur == sum) {
                cur = 0;
                segs++;
            }
        }
        return segs >= 3;
    }
}
