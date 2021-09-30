package monoStack;

import java.util.*;

public class _496_next_greater_element_i {
    // nums1 is like a query
    // stack.push(ele) when you want to deal with ele later
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++) {
            if(stack.isEmpty() || nums2[i] <= stack.peek()) {
                stack.push(nums2[i]);
            } else { // nums2[i] > stack.peek()
                while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.add(nums2[i]);
            }
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return res;
    }
}
