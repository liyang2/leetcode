package math;
import java.util.*;
public class _149_max_points_on_a_line {
    public int maxPoints(int[][] points) {
        if(points.length < 2) return points.length;
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            Map<String, Integer> count = new HashMap<>();
            int overlap = 0;
            int max = 0;
            for(int j = i+1; j < points.length; j++) {
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    overlap++;
                    continue;
                }
                String slope = getSlope(points[i][0], points[i][1], points[j][0], points[j][1]);
                count.put(slope, count.getOrDefault(slope, 0)+1);
                max = Math.max(max, count.get(slope));
            }
            res = Math.max(res, max+overlap+1); // 1 means point[i] itself
        }

        return res;
    }

    int gcd(int x, int y) {
        if(x == 0) return y;
        return gcd(y % x, x);
    }

    String getSlope(int x1, int y1, int x2, int y2)  {
        int deltaX = x2 - x1;
        int deltaY = y2 - y1;

        if(deltaX == 0) {
            return "#";
        } else {
            int d = gcd(deltaX, deltaY);
            deltaX /= d;
            deltaY /= d;
            return deltaY + "/" + deltaX;
        }
    }
}
