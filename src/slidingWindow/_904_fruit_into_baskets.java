package slidingWindow;

public class _904_fruit_into_baskets {
    public int totalFruit(int[] fruits) {
        int res = 0;
        int curKind = 0;
        int l = 0, r= 0;
        int n = fruits.length;
        int[] count = new int[n];

        for(r = 0; r < fruits.length; r++) {
            count[fruits[r]]++;
            if(count[fruits[r]] == 1) {
                curKind++;
            }
            while(l <= r && curKind > 2) {
                count[fruits[l]]--;
                if(count[fruits[l]] == 0) {
                    curKind--;
                }
                l++;
            }
            res = Math.max(res, r -l+1);
        }
        return res;
    }
}


