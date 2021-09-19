package arrary;

public class _1103_distribute_candies {
    public int[] distributeCandies(int candies, int n) {
        int[] arr = new int[n];
        int idx = 0;
        int curCandy = 1;
        while(candies > 0) {
            int give = Math.min(candies, curCandy++);
            arr[idx] += give;
            candies -= give;
            idx = (idx+1) % n;
        }
        return arr;
    }
}
