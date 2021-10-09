package math;

import java.util.*;

public class _166_fraction_to_recurring_decimal {
    // assume d != 0
    public String fractionToDecimal(int n, int d) {
        if(n == 0) return "0";
        long nL = Math.abs(Long.valueOf(n));
        long dL = Math.abs(Long.valueOf(d));
        StringBuilder sb = new StringBuilder();
        if(n > 0 ^ d > 0)  // different sign
            sb.append("-");
        sb.append(nL/dL);
        long remainder = nL % dL;
        if(remainder == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                sb.insert(map.get(remainder), "(");
                sb.append(")");
                return sb.toString();
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder/ dL);
            remainder %= dL;
        }
        return sb.toString();
    }
}
