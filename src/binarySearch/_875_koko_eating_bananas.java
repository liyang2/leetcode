package binarySearch;

import java.util.Arrays;

public class _875_koko_eating_bananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxK = Arrays.stream(piles).max().getAsInt();
        int minK = 1;
        while (minK + 1 < maxK) {
            int mid = minK + (maxK - minK) / 2;
            if (canEatAll(piles, mid, h)) {
                if (!canEatAll(piles, mid-1, h)) {
                    return mid;
                } else {
                    maxK = mid - 1;
                }
            } else {
                minK = mid + 1;
            }
        }
        // now minK + 1 == maxK, just have to check minK and maxK now
        if (canEatAll(piles, minK, h)) {
            return minK;
        } else {
            return maxK;
        }
    }

    private boolean canEatAll(int[] piles, int k, int hours) {
        int time = 0;
        for (int p : piles) {
            time += (p - 1) / k + 1;
        }
        return time <= hours;
    }
}
