package sorting;

import java.util.Arrays;

public class _853_car_fleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = speed.length;
        Item[] posAndTime = new Item[len];
        for (int i = 0; i < len; i++) {
            posAndTime[i] = new Item(position[i], (double)(target - position[i]) / speed[i]);
        }

        Arrays.sort(posAndTime, (o1, o2) -> o1.position - o2.position);
        int res = 0;
        double maxTime = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (posAndTime[i].time > maxTime) {
                res++;
                maxTime = posAndTime[i].time;
            }
        }
        return res;
    }
}

class Item {
    int position;
    double time;
    public Item(int position, double time) {
        this.position = position;
        this.time = time;
    }
}
