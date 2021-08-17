package amazon;

import java.lang.reflect.Array;
import java.util.*;

public class _315_count_of_smaller_numbers_after_self {

    public static void main(String[] args) {
        new _315_count_of_smaller_numbers_after_self().countSmaller(new int[]{5,2,6,1});
    }

    public List<Integer> countSmaller(int[] nums) {
        int[][] items = new int[nums.length][2];
        Integer[] res = new Integer[nums.length];
        Arrays.fill(res, 0);
        for(int i = 0; i < nums.length; i++) {
            items[i] = new int[]{i, nums[i]};
        }
        mergesort(items, res, 0, nums.length-1);
        return Arrays.asList(res);
    }

    void mergesort(int[][] items, Integer[] res, int begin, int end) {
        if(begin >= end)  return;
        int mid = (begin + end) / 2;
        mergesort(items, res, begin, mid);
        mergesort(items, res, mid+1, end);
        merge(items, res, begin, mid, end);
    }

    void merge(int[][] items, Integer[] res, int begin, int mid, int end) {
        int i = begin;
        int j = mid+1;
        int[][] temp = new int[end-begin+1][2];
        int idx = 0;

        // items[begin, mid] and items[mid+1, end] are sorted
        while(i <= mid && j <= end) {
            if(items[i][1] <= items[j][1]) {
                res[items[i][0]] += j - (mid+1);
                temp[idx++] = items[i++];
            } else {
                temp[idx++] = items[j++];
            }
        }

        while(i <= mid) {
            res[items[i][0]] += j - (mid+1);
            temp[idx++] = items[i++];
        }
        while(j <= end) {
            temp[idx++] = items[j++];
        }
        for(int k = begin; k <= end; k++) {
            items[k] = temp[k - begin];
        }

    }
}
