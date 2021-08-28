package monoStack;

import java.util.*;

public class _496_next_greater_element_i {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int n : nums2) {
            while(!stack.isEmpty() && n > stack.peek()) {
                int d = stack.pop();
                map.put(d, n);
            }
            stack.push(n);
        }
        int[] arr = new int[nums1.length];
        Arrays.fill(arr, -1);
        for(int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])) {
                arr[i] = map.get(nums1[i]);
            }
        }
        return arr;
    }
}
