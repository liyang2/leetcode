package gameTheory;
import java.util.*;
public class _1025_divisor_game {
    Map<Integer, Boolean> map = new HashMap<>();

    public boolean divisorGame(int n) {
        if(map.containsKey(n))
            return map.get(n);

        for(int i = 1; i < n; i++) {
            if(n % i == 0 && !divisorGame(n-i)) {
                map.put(n, true);
                return true;
            }
        }
        map.put(n, false);
        return false;
    }
}
