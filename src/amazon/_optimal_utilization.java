package amazon;

import java.util.*;

// https://leetcode.com/discuss/interview-question/373202
public class _optimal_utilization {
    public int[][] foo(int[][] a, int[][] b, int target) {
        Arrays.sort(a, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        Arrays.sort(b, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        int left = 0, right = b.length-1;
        List<int[]> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        while(left < a.length && right >= 0) {
            int[] aa = a[left];
            int[] bb = b[right];
            int sum = aa[1] + bb[1];
            if(sum <= target) {
                if (sum > max) {
                    max = sum;
                    list.clear();
                    list.add(new int[]{aa[0], bb[0]});
                } else if(sum == max) {
                    list.add(new int[]{aa[0], bb[0]});
                }
                left++;
            } else {
                right--;
            }
        }
        int[][] res = new int[list.size()][];
        list.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        _optimal_utilization solution = new _optimal_utilization();

        int[][] a = {{1,3},{2,5},{3,7},{4,10}};
        int[][] b = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(toString(solution.foo(a, b, 10)));
    }

    private static String toString(int[][] foo) {
        StringBuilder sb= new StringBuilder();
        for(int[] arr : foo) {
            sb.append(Arrays.toString(arr));
            sb.append("\n");
        }
        return sb.toString();
    }
}
