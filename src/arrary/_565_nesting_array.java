package arrary;

public class _565_nesting_array {
    public int arrayNesting(int[] nums) {
        int res  = 0;
        boolean[] visited = new boolean[nums.length];
        for(int k = 0; k < nums.length; k++) {
            if(visited[k]) continue;

            int i = k, count = 0;
            do {
                i = nums[i];
                visited[i] = true;
                count ++;
            } while(i != k);
            res = Math.max(res, count);


        }
        return res;
    }
}
