package heap;

import java.util.PriorityQueue;

public class _1792_max_avg_pass_ratio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> q = new PriorityQueue<>((o1, o2) -> Double.compare(o2[0], o1[0])); // biggest at the head

        for(int[] c : classes) {
            int pass = c[0];
            int total = c[1];
            double inc = profitInc(pass, total);
            q.add(new double[]{inc, pass, total});
        }

        while(extraStudents -- > 0) {
            double[] arr = q.poll();
            double pass = arr[1];
            double total = arr[2];
            q.add(new double[]{profitInc(pass+1, total+1), pass+1, total+1});
        }

        double res = 0.0;
        while(!q.isEmpty()) {
            double[] arr = q.poll();
            double pass = arr[1];
            double total = arr[2];
            res += pass/ total;
        }
        res /= classes.length;
        return res;
    }

    private double profitInc(double pass, double total) {
        return (pass+1)/(total+1) - pass/total;
    }
}
