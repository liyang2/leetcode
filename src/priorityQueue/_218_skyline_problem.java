package priorityQueue;

import java.util.*;

//https://www.youtube.com/watch?v=GSBLe8cKu0s

public class _218_skyline_problem {
    static class Point {
        public int x;
        public int y;
        public boolean isStart;

        public Point(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        for(int[] b : buildings) {
            points.add(new Point(b[0], b[2], true));
            points.add(new Point(b[1], b[2], false));
        }
        Collections.sort(points, (o1, o2) -> {
            Point p1 = (Point)o1;
            Point p2 = (Point)o2;
            if(p1.x == p2.x && p1.isStart != p2.isStart) {
                return p1.isStart ? -1 : 1;
            }
            return p1.x - p2.x;
        });

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        q.add(0);
        int prevHeight = 0;

        for(Point p : points) {
            if(p.isStart) {
                q.add(p.y);
            } else {
                q.remove(p.y);
            }
            int curHeight = q.peek();
            if(curHeight != prevHeight) {
                res.add(Arrays.asList(p.x, curHeight));
                prevHeight = curHeight;
            }
        }

        List<List<Integer>> finalRes = new ArrayList<>();
        for(int i = 0; i < res.size()-1; i++) {
            List<Integer> item = res.get(i);
            List<Integer> next = res.get(i+1);
            if(item.get(0).equals(next.get(0))) continue; // same x

            finalRes.add(item);
        }
        finalRes.add(res.get(res.size()-1));

        return finalRes;
    }
}
