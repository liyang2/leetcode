package binarySearch;

public class _278_first_bad_version {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)) {
                if(mid == 1 || !isBadVersion(mid-1))
                    return mid;
                else
                    right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    // have to provide this so that it compiles
    boolean isBadVersion(int x) {
        return true;
    }
}
