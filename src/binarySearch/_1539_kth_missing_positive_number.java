package binarySearch;

import java.util.ArrayList;
import java.util.List;

public class _1539_kth_missing_positive_number {
    // this logN solution is not easy at all
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int missing = arr[mid] - (mid+1); // use an example to conclude this
            if(missing < k) {
                left = mid+1;
            } else { // search left if missing == k
                right = mid-1;
            }
        }
        return left+k;
    }

    public int findKthPositive_linearTime(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int n : arr) list.add(n);


        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) == list.get(i-1)+1) {
                continue;
            } else {
                if(list.get(i-1) + k < list.get(i)) {
                    return list.get(i-1) + k;
                } else {
                    k -= list.get(i) - list.get(i-1)-1;
                }
            }
        }
        return list.get(list.size()-1)+k;
    }
}
