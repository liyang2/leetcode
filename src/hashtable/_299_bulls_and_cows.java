package hashtable;

public class _299_bulls_and_cows {
    //https://leetcode.com/problems/bulls-and-cows/discuss/74621/One-pass-Java-solution
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] arr = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s == g) { // bulls don't need arr[]
                bulls++;
            } else {
                if(arr[s-'0'] < 0)
                    cows++;
                if(arr[g-'0'] > 0)
                    cows++;
                arr[s-'0']++; // 填坑
                arr[g-'0']--; // 挖坑
            }
        }
        return bulls+"A"+cows+"B";
    }
}
