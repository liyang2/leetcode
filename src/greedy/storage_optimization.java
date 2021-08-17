package greedy;

import java.util.Arrays;

public class storage_optimization {
    //https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long MOD = 1000000007;
        long maxH = Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]);
        for(int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i]-horizontalCuts[i-1]);
        }

        long maxW = Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length-1]);
        for(int i = 1; i < verticalCuts.length; i++) {
            maxW = Math.max(maxW, verticalCuts[i]-verticalCuts[i-1]);
        }


        return (int)((maxH * maxW) % MOD);
    }
}
