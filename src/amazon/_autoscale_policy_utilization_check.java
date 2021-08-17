package amazon;

public class _autoscale_policy_utilization_check {

    int foo(int instances, int[] avgUtil) {
        int index = 0;
        final int MAX = 2*108;

        while (index < avgUtil.length) {
            if(avgUtil[index] < 25) {
                int toReduce = (int)Math.ceil((double)instances/2);
                instances -= toReduce;
                index += 10;
            } else if(avgUtil[index] > 60 && instances * 2 < MAX)  {
                instances *= 2;
                index += 10;
            }
            index++;
        }
        return instances;
    }

    public static void main(String[] args) {
        _autoscale_policy_utilization_check solution = new _autoscale_policy_utilization_check();
        System.out.println(solution.foo(2, new int[]{25, 23, 1, 2, 3, 4, 5, 6,7,8,9,10,76,80}));
    }
}
